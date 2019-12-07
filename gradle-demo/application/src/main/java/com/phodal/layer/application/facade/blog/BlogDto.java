package com.phodal.layer.application.facade.blog;

import com.phodal.layer.application.domain.blog.Blog;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BlogDto {
    private String id;
    private String title;
    private String body;


    static BlogDto of(Blog blog) {
        return new BlogDto(
                blog.getId(),
                blog.getTitle(),
                blog.getBody());
    }
}
