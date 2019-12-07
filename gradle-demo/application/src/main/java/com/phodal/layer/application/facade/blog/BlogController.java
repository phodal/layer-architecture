package com.phodal.layer.application.facade.blog;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {
    @RequestMapping("/")
    public String home() {
        return "Greetings from Spring Boot!";
    }

}
