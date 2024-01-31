package com.devmadhurendra.backend.controller;

import com.devmadhurendra.backend.dto.UrlDto;
import com.devmadhurendra.backend.entity.Url;
import com.devmadhurendra.backend.service.UrlService;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UrlShortenerControllerTest {

    @Mock
    private UrlService urlService;

    @InjectMocks
    private UrlShortenerController urlShortenerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGenerateShortUrlSuccess() {
        UrlDto urlDto = new UrlDto();
        urlDto.setUrl("http://example.com");

        Url url = new Url();
        url.setOriginalUrl(urlDto.getUrl());
        url.setShortUrl("http://short.url");
        url.setExpiresAt(LocalDateTime.now().plusHours(2));

        when(urlService.generateShortUrl(any())).thenReturn(url);

        ResponseEntity<?> responseEntity = urlShortenerController.generateShortUrl(urlDto);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }

    @Test
    void testGenerateShortUrlFailure() {
        UrlDto urlDto = new UrlDto();
        urlDto.setUrl("http://example.com");

        when(urlService.generateShortUrl(any())).thenReturn(null);

        ResponseEntity<?> responseEntity = urlShortenerController.generateShortUrl(urlDto);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    void testRedirectToOriginalUrlSuccess() throws IOException {
        String shortUrl = "http://short.url";

        Url url = new Url();
        url.setOriginalUrl("http://example.com");
        url.setShortUrl(shortUrl);
        url.setExpiresAt(LocalDateTime.now().plusHours(2));

        when(urlService.getEncodedUrl(shortUrl)).thenReturn(url);

        HttpServletResponse response = mock(HttpServletResponse.class);

        ResponseEntity<?> responseEntity = urlShortenerController.redirectToOriginalUrl(shortUrl, response);

        verify(response, times(1)).sendRedirect(url.getOriginalUrl());
        assertEquals(null, responseEntity);
    }

    @Test
    void testRedirectToOriginalUrlExpired() throws IOException {
        String shortUrl = "http://expired.url";

        Url url = new Url();
        url.setOriginalUrl("http://example.com");
        url.setShortUrl(shortUrl);
        url.setExpiresAt(LocalDateTime.now().minusHours(1));

        when(urlService.getEncodedUrl(shortUrl)).thenReturn(url);

        HttpServletResponse response = mock(HttpServletResponse.class);

        ResponseEntity<?> responseEntity = urlShortenerController.redirectToOriginalUrl(shortUrl, response);

        verify(urlService, times(1)).deleteShortUrl(url);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    void testRedirectToOriginalUrlInvalid() throws IOException {
        String shortUrl = null;

        HttpServletResponse response = mock(HttpServletResponse.class);

        ResponseEntity<?> responseEntity = urlShortenerController.redirectToOriginalUrl(shortUrl, response);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }
}
