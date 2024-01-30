package com.devmadhurendra.backend.util;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

public class AppFunctions {
    public static String encodeUrl(String url)
    {
        LocalDateTime time = LocalDateTime.now();
        return Hashing
                .murmur3_32()
                .hashString(url.concat(time.toString()), StandardCharsets.UTF_8)
                .toString();
    }
}
