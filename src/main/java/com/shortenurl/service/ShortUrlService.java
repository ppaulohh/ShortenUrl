package com.shortenurl.service;

import com.shortenurl.model.ShortUrl;
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
public class ShortUrlService {

    /* Variables */
    private final Map<String, ShortUrl> shortUrlList = new HashMap<>();
    private UrlValidator validator = new UrlValidator(new String[]{"http","https"});

    /* Functions to create the random links and store then */
    public ResponseEntity<Object> shrink(ShortUrl shortenUrl) {
        if(validator.isValid(shortenUrl.getFullUrl())) {
            String randomChar = this.getRandomChars();
            this.createShortUrl(randomChar, shortenUrl);
            return new ResponseEntity(shortenUrl, HttpStatus.OK);
        }
        shortenUrl.setShortenedUrl("insira URL válida");
        return new ResponseEntity(shortenUrl, HttpStatus.OK);

    }

    private String getRandomChars() {
        String randomStr = "";
        String possibleChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        for(int i = 0; i < 5; ++i) {
            randomStr = randomStr + possibleChars.charAt((int)Math.floor(Math.random() * (double)possibleChars.length()));
        }

        return randomStr;
    }

    private void createShortUrl(String randomChar, ShortUrl shortenUrl) {
        shortenUrl.setShortenedUrl("http://localhost:8080/s/" + randomChar);
        this.shortUrlList.put(randomChar, shortenUrl);
    }


    /* Redirect function to retrieve the long URL*/
    public void redirect(HttpServletResponse response, @PathVariable("randomstring") String randomString) throws IOException {
        response.sendRedirect(((ShortUrl)this.shortUrlList.get(randomString)).getFullUrl());
    }
}
