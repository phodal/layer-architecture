package com.phodal.layer.application.facade.blog;

import com.phodal.layer.application.application.blog.QueryBlogUseCase;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/blog")
public class BlogController {
    private final QueryBlogUseCase queryBlogUseCase;

    public BlogController(QueryBlogUseCase queryBlogUseCase) {
        this.queryBlogUseCase = queryBlogUseCase;
    }

    @RequestMapping("/home")
    public String home() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/{id}")
    public BlogDto get(@PathVariable String id) {
        return BlogDto.of(queryBlogUseCase.get(id));
    }
}
