package com.url.shortner.userservice.service.impl;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
@Slf4j
public class EmailServiceImpl  {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendOtpMailService(String email) {
        String otp = generateOtp();
        try {
            System.out.println(otp);
            log.info("in try block of sendOtpMailService method");
            sendOtpToMail(email, otp);
        } catch (MessagingException e) {
            log.error("Error sending OTP email", e);
            throw new RuntimeException("Unable to send OTP");
        }
    }


    private String generateOtp() {
        Random random = new Random();
        int otpValue = 100000 + random.nextInt(900000);
        return String.valueOf(otpValue);
    }


    public void sendOtpToMail(String email, String otp) throws  MessagingException {
        System.out.println(otp);
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        mimeMessageHelper.setTo(email);
        mimeMessageHelper.setSubject("Your OTP is : ");
        mimeMessageHelper.setText(otp);
        javaMailSender.send(mimeMessage);
    }
 }
