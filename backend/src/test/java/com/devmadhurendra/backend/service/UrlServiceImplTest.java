package com.devmadhurendra.backend.service;

import com.devmadhurendra.backend.dto.UrlDto;
import com.devmadhurendra.backend.entity.Url;
import com.devmadhurendra.backend.repository.UrlRepository;
import com.devmadhurendra.backend.service.serviceimpl.UrlServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UrlServiceImplTest {

    @Mock
    private UrlRepository urlRepository;

    @InjectMocks
    private UrlServiceImpl urlService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGenerateShortUrlSuccess() {
        UrlDto urlDto = new UrlDto();
        urlDto.setUrl("http://example.com");

        Url urlToPersist = Url
                .builder()
                .originalUrl(urlDto.getUrl())
                .shortUrl("http://short.url")
                .createdAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusHours(2))
                .build();

        when(urlRepository.save(any())).thenReturn(urlToPersist);

        Url result = urlService.generateShortUrl(urlDto);

        assertEquals("http://short.url", result.getShortUrl());
    }

    @Test
    void testGenerateShortUrlFailure() {
        UrlDto urlDto = new UrlDto();
        urlDto.setUrl(null);

        Url result = urlService.generateShortUrl(urlDto);

        assertEquals(null, result);
    }

    @Test
    void testPersistShortUrl() {
        Url urlToPersist = Url
                .builder()
                .originalUrl("http://example.com")
                .shortUrl("http://short.url")
                .createdAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusHours(2))
                .build();

        when(urlRepository.save(any())).thenReturn(urlToPersist);

        Url result = urlService.persistShortUrl(urlToPersist);

        assertEquals("http://short.url", result.getShortUrl());
    }

    @Test
    void testGetEncodedUrl() {
        String shortUrl = "http://short.url";

        Url url = Url
                .builder()
                .originalUrl("http://example.com")
                .shortUrl(shortUrl)
                .createdAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusHours(2))
                .build();

        when(urlRepository.findByShortUrl(shortUrl)).thenReturn(url);

        Url result = urlService.getEncodedUrl(shortUrl);

        assertEquals("http://example.com", result.getOriginalUrl());
    }

    @Test
    void testDeleteShortUrl() {
        Url urlToDelete = Url
                .builder()
                .originalUrl("http://example.com")
                .shortUrl("http://short.url")
                .createdAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusHours(2))
                .build();

        doNothing().when(urlRepository).delete(urlToDelete);

        urlService.deleteShortUrl(urlToDelete);

        verify(urlRepository, times(1)).delete(urlToDelete);
    }
}
