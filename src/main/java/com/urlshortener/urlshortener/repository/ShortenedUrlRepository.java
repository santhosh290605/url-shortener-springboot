package com.urlshortener.urlshortener.repository;

import com.urlshortener.urlshortener.model.ShortenedUrl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShortenedUrlRepository extends JpaRepository<ShortenedUrl,Integer> {

    public boolean existsByShortCode(String shortCode);
    public Optional<ShortenedUrl> findByOriginalUrl(String originalUrl);
}
