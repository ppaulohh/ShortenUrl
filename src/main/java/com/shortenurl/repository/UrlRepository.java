package com.shortenurl.repository;

import com.shortenurl.model.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UrlRepository extends JpaRepository<ShortUrl,Long> {
    List<ShortUrl> findByShortenedUrl(String shortenedUrl);
}
