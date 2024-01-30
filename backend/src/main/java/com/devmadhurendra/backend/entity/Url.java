package com.devmadhurendra.backend.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "url")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Url {

    @Id
    private String id;

    @Field
    private String originalUrl;

    @Field
    private String shortUrl;

    @Field
    private LocalDateTime createdAt;

    @Field
    private LocalDateTime expiresAt;
}
