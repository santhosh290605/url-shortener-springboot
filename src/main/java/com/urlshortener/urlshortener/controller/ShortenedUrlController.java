package com.urlshortener.urlshortener.controller;


import com.urlshortener.urlshortener.dto.ShortenUrlRequest;
import com.urlshortener.urlshortener.dto.ShortenUrlResponse;
import com.urlshortener.urlshortener.service.ShortenedUrlService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/urls")
public class ShortenedUrlController {

    private final ShortenedUrlService shortenedUrlService;

    public ShortenedUrlController(ShortenedUrlService shortenedUrlService){
        this.shortenedUrlService = shortenedUrlService;
    }


    @PostMapping("")
    public ShortenUrlResponse shortenUrl(@RequestBody ShortenUrlRequest request){

        String originalUrl = request.getUrl();
        ShortenUrlResponse shortenUrlResponse = new ShortenUrlResponse();

        shortenUrlResponse.setOriginalUrl(originalUrl);
        shortenUrlResponse.setShortenedUrl("http://localhost:8080/" + shortenedUrlService.shortenUrl(originalUrl));

        return shortenUrlResponse;
    }
}
