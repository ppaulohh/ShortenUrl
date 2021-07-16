package com.shortenurl.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShortUrl {

	private String fullUrl;
	private String shortenedUrl;
}
