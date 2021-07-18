package com.shortenurl.service;

import com.shortenurl.model.ShortUrl;
import com.shortenurl.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ShortUrlService {

    /* Variables */
    private final Map<String, ShortUrl> shortUrlList = new HashMap<>();
    private UrlValidator validator = new UrlValidator(new String[]{"http","https"});
    private final UrlRepository urlRepository;



    /* Functions to create the random links and store then */
    public String shrink(String fullUrl) {
        if(validator.isValid(fullUrl)) {
            String randomChar = this.getRandomChars();
            return this.createShortUrl(randomChar, fullUrl);
        }
        return "insira URL válida";

    }

    private String getRandomChars() {
        String randomStr = "";
        String possibleChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        for(int i = 0; i < 5; ++i) {
            randomStr = randomStr + possibleChars.charAt((int)Math.floor(Math.random() * (double)possibleChars.length()));
        }

        return randomStr;
    }

    private String createShortUrl(String randomChar, String fullUrl) {
        String shortUrl="http://localhost:8080/s/" + randomChar;
        urlRepository.save(new ShortUrl(shortUrl,fullUrl));
        return shortUrl;
    }


    /* Redirect function to retrieve the long URL*/
    public void redirect(HttpServletResponse response, @PathVariable("randomstring") String randomString) throws IOException {
        response.sendRedirect(((ShortUrl)this.shortUrlList.get(randomString)).getFullUrl());
    }
}
