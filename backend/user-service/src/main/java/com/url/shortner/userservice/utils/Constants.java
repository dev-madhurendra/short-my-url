package com.url.shortner.userservice.utils;

public class Constants {

    public static final String EMAIL_PATTERN = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    public static final String EMAIL_INVALID = "Invalid email address";
    public static final String PASSWORD_PATTERN = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{6,}$";
    public static final String PASSWORD_INVALID = "Password must be at least 6 characters with at least 1 uppercase letter, 1 lowercase letter, 1 digit, and 1 special character (@#$%^&+=!).";
    public static final String USERNAME_BLANK = "Username cannot be blank";
    public static final String IS_VERIFIED_BLANK = "isVerified cannot be blank";
    public static final String AUTHENTICATION_FAILED = "Authentication failed. Incorrect password.";


}
