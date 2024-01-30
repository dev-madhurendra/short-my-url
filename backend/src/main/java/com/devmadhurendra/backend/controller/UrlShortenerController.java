package com.devmadhurendra.backend.controller;

import com.devmadhurendra.backend.dto.UrlDto;
import com.devmadhurendra.backend.dto.UrlResponseDto;
import com.devmadhurendra.backend.entity.Url;
import com.devmadhurendra.backend.payload.ApiResponse;
import com.devmadhurendra.backend.service.UrlService;
import com.devmadhurendra.backend.util.AppConstants;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;

@RestController
@Slf4j
@RequestMapping(AppConstants.BASE_URL)
public class UrlShortenerController {

    private final UrlService urlService;

    @Autowired
    public UrlShortenerController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping(AppConstants.GENERATE)
    public ResponseEntity<?> generateShortUrl(@RequestBody UrlDto urlDto) {
        Url url = urlService.generateShortUrl(urlDto);

        if (url == null) {
            return new ResponseEntity<>(new ApiResponse(AppConstants.ERROR_MESSAGE,false),HttpStatus.BAD_REQUEST);
        }
        UrlResponseDto urlResponseDto =  UrlResponseDto
                .builder()
                .shortUrl(url.getShortUrl())
                .expirationAt(url.getExpiresAt())
                .originalUrl(url.getOriginalUrl())
                .build();

        log.info(">>> Url shortened {} : ", url.getShortUrl());
        return new ResponseEntity<>(urlResponseDto, HttpStatus.CREATED);
    }

    @GetMapping(AppConstants.GET_URL)
    public ResponseEntity<?> redirectToOriginalUrl(
            @PathVariable String zipUrl,
            HttpServletResponse response
    ) throws IOException {
        if (zipUrl == null) {
            return new ResponseEntity<>(new ApiResponse(AppConstants.INVALID_URL,false),HttpStatus.BAD_REQUEST);
        }
        Url url = urlService.getEncodedUrl(zipUrl);

        if (url == null || url.getExpiresAt().isBefore(LocalDateTime.now())) {
            if (url.getExpiresAt().isBefore(LocalDateTime.now())) {
                log.info(">>> Short url expired.");
                urlService.deleteShortUrl(url);
            }
            return new ResponseEntity<>(new ApiResponse(AppConstants.URL_ERROR,false),HttpStatus.BAD_REQUEST);
        }
        response.sendRedirect(url.getOriginalUrl());
        return null;
    }
}
