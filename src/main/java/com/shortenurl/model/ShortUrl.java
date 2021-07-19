package com.shortenurl.model;

import com.shortenurl.DTO.ShortUrlDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class ShortUrl {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String fullUrl;
	private String shortenedUrl;

	public ShortUrl(String fullUrl, String shortenedUrl) {
		this.fullUrl = fullUrl;
		this.shortenedUrl = shortenedUrl;
	}

	public ShortUrlDTO toDTO(){
		return new ShortUrlDTO(this.shortenedUrl,this.fullUrl);
	}

}
