package com.devmadhurendra.backend.service.serviceimpl;

import com.devmadhurendra.backend.dto.UrlDto;
import com.devmadhurendra.backend.entity.Url;
import com.devmadhurendra.backend.repository.UrlRepository;
import com.devmadhurendra.backend.service.UrlService;
import com.devmadhurendra.backend.util.AppFunctions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class UrlServiceImpl implements UrlService {

    private final UrlRepository urlRepository;

    @Autowired
    public UrlServiceImpl(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Override
    public Url generateShortUrl(UrlDto urlDto) {
        if (urlDto.getUrl() != null) {
            String encodeUrl = AppFunctions.encodeUrl(urlDto.getUrl());
            Url urlToPersist = Url
                    .builder()
                    .originalUrl(urlDto.getUrl())
                    .shortUrl(encodeUrl)
                    .createdAt(LocalDateTime.now())
                    .expiresAt(LocalDateTime.now().plusHours(2))
                    .build();
            Url urlToRet = persistShortUrl(urlToPersist);

            if (urlToRet != null) {
                return urlToRet;
            }
        }
        return null;
    }

    @Override
    public Url persistShortUrl(Url url) {
        return urlRepository.save(url);
    }

    @Override
    public Url getEncodedUrl(String url) {
        return urlRepository.findByShortUrl(url);
    }

    @Override
    public void deleteShortUrl(Url url) {
        urlRepository.delete(url);
    }

}
