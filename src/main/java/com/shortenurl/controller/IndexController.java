package com.shortenurl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    /* Set HTML for home function */
    public String loadIndex() { return "index.html";}

}
