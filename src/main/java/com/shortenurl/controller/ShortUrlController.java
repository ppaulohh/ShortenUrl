package com.shortenurl.controller;

import com.shortenurl.model.ShortUrl;
import com.shortenurl.service.ShortUrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ShortUrlController {

	private final ShortUrlService shortUrlService;

	@GetMapping("/thiswork")
	public String thiswork(){
		return "Yes";
	}

	@PostMapping("/shrink")
	public ResponseEntity<String> shrink(@RequestParam String fullUrl) {
		return new ResponseEntity<>(shortUrlService.shrink(fullUrl), HttpStatus.CREATED);
	}

	@GetMapping("/s/{randomString}")
	public void retrieve(HttpServletResponse response, @PathVariable String randomString) throws IOException {
		shortUrlService.redirect(response,randomString);

	}
}
