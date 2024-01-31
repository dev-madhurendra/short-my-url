package com.devmadhurendra.backend.service;

import com.devmadhurendra.backend.dto.UrlDto;
import com.devmadhurendra.backend.entity.Url;

public interface UrlService {
    Url generateShortUrl(UrlDto urlDto);
    Url persistShortUrl(Url url);
    Url getEncodedUrl(String url);
    void deleteShortUrl(Url url);

}
