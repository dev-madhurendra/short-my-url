package com.url.shortner.userservice.service.impl;

import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Service
public class OtpStore {
    private final Map<String, OtpEntry> otpStore = new ConcurrentHashMap<>();
    private static final long OTP_EXPIRATION_MINUTES = 5;

    public void storeOtp(String email, String otp) {
        otpStore.put(email, new OtpEntry(otp, Instant.now()));
    }

    public boolean validateOtp(String email, String userOtp) {
        OtpEntry entry = otpStore.get(email);
        if (entry != null && entry.getOtp().equals(userOtp)) {
            if (Duration.between(entry.getCreatedAt(), Instant.now()).toMinutes() <= OTP_EXPIRATION_MINUTES) {
                return true;
            }
        }
        return false;
    }

    public void clearOtp(String email) {
        otpStore.remove(email);
    }

    private static class OtpEntry {
        private final String otp;
        private final Instant createdAt;

        public OtpEntry(String otp, Instant createdAt) {
            this.otp = otp;
            this.createdAt = createdAt;
        }

        public String getOtp() {
            return otp;
        }

        public Instant getCreatedAt() {
            return createdAt;
        }
    }
}
