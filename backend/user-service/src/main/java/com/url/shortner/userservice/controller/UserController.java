package com.url.shortner.userservice.controller;

import com.url.shortner.userservice.dto.LoginDTO;
import com.url.shortner.userservice.dto.OtpVerificationRequest;
import com.url.shortner.userservice.dto.UserDTO;
import com.url.shortner.userservice.entity.User;
import com.url.shortner.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO) {
        try {
            User registeredUser = userService.register(userDTO);
            return new ResponseEntity<>("User registered successfully with ID: " + registeredUser.getId(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticateAndSendOTP(@RequestBody LoginDTO loginDTO) {
        try {
            userService.authenticateAndSendOTP(loginDTO.getEmail(), loginDTO.getPassword());
            return new ResponseEntity<>("Authentication successful. OTP sent to your email.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<String> verifyOtp(@RequestBody OtpVerificationRequest request) {
        boolean isOtpValid = userService.verifyOtp(request.getEmail(), request.getOtp());

        if (isOtpValid) {
            return ResponseEntity.ok("OTP verified successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid OTP or OTP expired.");
        }
    }
}
