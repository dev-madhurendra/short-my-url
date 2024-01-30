package com.devmadhurendra.backend.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UrlDto {
    private String url;
    private LocalDateTime expirationAt;
}
