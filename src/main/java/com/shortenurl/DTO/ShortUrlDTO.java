package com.shortenurl.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShortUrlDTO {
    String shortUrl;
    String fullUrl;
}
