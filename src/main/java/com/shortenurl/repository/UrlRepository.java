package com.shortenurl.repository;

import com.shortenurl.model.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UrlRepository extends JpaRepository<ShortUrl,Long> {

}
