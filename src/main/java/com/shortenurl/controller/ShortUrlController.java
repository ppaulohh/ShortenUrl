package com.shortenurl.controller;

import com.shortenurl.DTO.ShortUrlDTO;
import com.shortenurl.service.ShortUrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ShortUrlController {

	private final ShortUrlService shortUrlService;

	@GetMapping("/thiswork")
	public String thiswork(){
		return "Yes";
	}

	@PostMapping("/shrink")
	public ResponseEntity<String> shrink(@RequestBody String fullUrl) {
		return new ResponseEntity<>(shortUrlService.shrink(fullUrl), HttpStatus.CREATED);
	}

	@GetMapping("/s/{randomString}")
	public void retrieve(HttpServletResponse response, @PathVariable String randomString) throws IOException {
		shortUrlService.redirect(response,randomString);
	}

	@GetMapping("/show")
	public List<ShortUrlDTO> show(){
		Long id = 0L;
		return shortUrlService.urlList(id);
		}
}
