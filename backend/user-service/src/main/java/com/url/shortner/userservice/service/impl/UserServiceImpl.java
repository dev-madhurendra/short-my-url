package com.url.shortner.userservice.service.impl;

import com.url.shortner.userservice.dto.UserDTO;
import com.url.shortner.userservice.entity.User;
import com.url.shortner.userservice.exception.AuthenticationFailedException;
import com.url.shortner.userservice.exception.UserNotFoundException;
import com.url.shortner.userservice.mapper.UserMapper;
import com.url.shortner.userservice.repository.UserRepository;
import com.url.shortner.userservice.service.UserService;
import com.url.shortner.userservice.utils.Constants;
import com.url.shortner.userservice.utils.UserMessages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private EmailServiceImpl emailService;

    @Autowired
    private OtpStore otpStore;

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException(String.format(UserMessages.USER_NOT_FOUND_BY_EMAIL, email)));
    }


    @Override
    public User register(UserDTO userDTO) {
        Optional<User> existingUser = userRepository.findByEmail(userDTO.getEmail());
        if (existingUser.isPresent()) {
            log.error(String.format(UserMessages.USER_CREATION_FAILED, userDTO.getEmail()));
            throw new UserNotFoundException(String.format(UserMessages.USER_ALREADY_EXISTS, userDTO.getEmail()));
        }
        try {
            User user = userMapper.convertToUser(userDTO);
            String encryptedPassword = bCryptPasswordEncoder.encode(user.getPassword());
            user.setPassword(encryptedPassword);
            return userRepository.save(user);
        } catch (UserNotFoundException e) {
            log.error(UserMessages.UNABLE_TO_SAVE_USER, e);
            throw new UserNotFoundException(UserMessages.UNABLE_TO_SAVE_USER);
        }
    }

    @Override
    public void authenticateAndSendOTP(String email, String enteredPassword) {
        Optional<User> existingUser = userRepository.findByEmail(email);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            if (bCryptPasswordEncoder.matches(enteredPassword, user.getPassword())) {
                log.info("enetred into password checking if block");
                emailService.sendOtpMailService(email);
            } else {
                System.out.println(Constants.AUTHENTICATION_FAILED);
                log.error(String.format(Constants.AUTHENTICATION_FAILED, email));
                throw new AuthenticationFailedException(Constants.AUTHENTICATION_FAILED);
            }

        } else {
            log.error(String.format(UserMessages.USER_NOT_FOUND, email));
            throw new UserNotFoundException(String.format(UserMessages.USER_NOT_FOUND, email));
        }
    }

    public boolean verifyOtp(String email, String otp) {
        boolean isValid = otpStore.validateOtp(email, otp);
        if (isValid) {
            otpStore.clearOtp(email);
            return true;
        }
        return false;
    }


}
