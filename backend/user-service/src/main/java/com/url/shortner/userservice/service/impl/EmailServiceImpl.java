package com.url.shortner.userservice.service.impl;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class EmailServiceImpl  {


    @Autowired
    private JavaMailSender javaMailSender;


    public void sendOtpMailService(String email){
         String otp=generateOtp();
         try{
             sendOtpToMail(email,otp);
         }catch (MessagingException e){
             throw new RuntimeException("unable to send otp");
         }
    }

    private String generateOtp() {
        Random random = new Random();
        int otpValue = 100000 + random.nextInt(900000);
        return String.valueOf(otpValue);
    }


    private void sendOtpToMail(String email, String otp) throws  MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        mimeMessageHelper.setTo(email);
        mimeMessageHelper.setSubject("Your OTP is : ");
        mimeMessageHelper.setText(otp);
        javaMailSender.send(mimeMessage);
    }
 }
