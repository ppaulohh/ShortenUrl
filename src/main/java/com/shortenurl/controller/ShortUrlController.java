package com.shortenurl.controller;

import com.shortenurl.model.ShortUrl;
import com.shortenurl.service.ShortUrlService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class ShortUrlController {

	private final ShortUrlService shortUrlService;
	public ShortUrlController(ShortUrlService shortUrlService) { this.shortUrlService = shortUrlService; }



	@GetMapping("/thiswork")
	public String thiswork(){
		return "Yes";
	}

	@PostMapping("/shrink")
	public ResponseEntity<Object> shrink(@RequestBody ShortUrl shortUrl) {
		return shortUrlService.shrink(shortUrl);
	}

	@GetMapping("/s/{randomString}")
	public void retrieve(HttpServletResponse response, @PathVariable String randomString) throws IOException {
		shortUrlService.redirect(response,randomString);

	}
}
