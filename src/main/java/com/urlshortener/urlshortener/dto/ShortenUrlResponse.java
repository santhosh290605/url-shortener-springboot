package com.urlshortener.urlshortener.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ShortenUrlResponse {

    private String originalUrl;
    private String shortenedUrl;
}
