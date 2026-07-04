package com.urlshortener.urlshortener.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.ZonedDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShortenedUrl {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String originalUrl;

    @Column(nullable = false,unique = true)
    private String shortCode;

    @CreationTimestamp
    @Column(name = "created_at",nullable = false,updatable = false)
    private ZonedDateTime createdAt;
}
