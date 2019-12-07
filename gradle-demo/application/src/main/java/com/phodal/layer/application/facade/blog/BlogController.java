package com.phodal.layer.application.facade.blog;

import com.phodal.layer.application.application.blog.EditBlogUseCase;
import com.phodal.layer.application.application.blog.QueryBlogUseCase;
import com.phodal.layer.application.facade.blog.representation.BlogDto;
import lombok.var;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/blog")
public class BlogController {
    private final QueryBlogUseCase queryBlogUseCase;
    private final EditBlogUseCase editBlogUseCase;

    public BlogController(QueryBlogUseCase queryBlogUseCase, EditBlogUseCase editBlogUseCase) {
        this.queryBlogUseCase = queryBlogUseCase;
        this.editBlogUseCase = editBlogUseCase;
    }

    @RequestMapping("/home")
    public String home() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/{id}")
    public BlogDto get(@PathVariable String id) {
        return BlogDto.of(queryBlogUseCase.get(id));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> post(@RequestBody CreateBlogRequest data, UriComponentsBuilder uriComponentsBuilder) {
        var blog = editBlogUseCase.create(data.title, data.body);
        UriComponents uriComponents = uriComponentsBuilder.path("/blog/{id}").buildAndExpand(blog.getId());
        return ResponseEntity.created(uriComponents.toUri()).body(BlogDto.of(blog));
    }
}
