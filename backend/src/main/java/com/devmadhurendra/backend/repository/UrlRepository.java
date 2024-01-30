package com.devmadhurendra.backend.repository;

import com.devmadhurendra.backend.entity.Url;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends MongoRepository<Url,Long> {
    Url findByShortUrl(String shortUrl);
}
