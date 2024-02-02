package com.url.shortner.userservice.service;


import com.url.shortner.userservice.dto.UserDTO;
import com.url.shortner.userservice.entity.User;

public interface UserService {


    public User getUserByEmail(String email);

    public User register(UserDTO userDTO);

    void authenticateAndSendOTP(String email, String enteredPassword);

    boolean verifyOtp(String email, String otp);
}