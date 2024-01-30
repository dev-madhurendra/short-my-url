package com.devmadhurendra.backend.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UrlResponseDto {
    private String originalUrl;
    private String shortUrl;
    private LocalDateTime expirationAt;
}
