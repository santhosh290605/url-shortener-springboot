package com.urlshortener.urlshortener.service;

import com.urlshortener.urlshortener.model.ShortenedUrl;
import com.urlshortener.urlshortener.repository.ShortenedUrlRepository;
import com.urlshortener.urlshortener.util.ShortCodeGenerator;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShortenedUrlService {

    private final ShortenedUrlRepository repo;

    public ShortenedUrlService(ShortenedUrlRepository repo) {
        this.repo = repo;
    }

    public String shortenUrl(String originalUrl){

        Optional<ShortenedUrl> existingEntity = repo.findByOriginalUrl(originalUrl);

        if (existingEntity.isPresent()) return existingEntity.get().getShortCode();

        String shortenedUrl = ShortCodeGenerator.generateRandomShortCode();

        while (repo.existsByShortCode(shortenedUrl)){
            shortenedUrl = ShortCodeGenerator.generateRandomShortCode();
        }

        ShortenedUrl shortenedUrlEntity = new ShortenedUrl();
        shortenedUrlEntity.setOriginalUrl(originalUrl);
        shortenedUrlEntity.setShortCode(shortenedUrl);

        repo.save(shortenedUrlEntity);
        return shortenedUrl;

    }
}
