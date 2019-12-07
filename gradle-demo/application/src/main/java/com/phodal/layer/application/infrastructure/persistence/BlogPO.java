package com.phodal.layer.application.infrastructure.persistence;

import com.phodal.layer.application.domain.blog.Blog;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class BlogPO {
    private String id;
    private String title;
    private String body;

    public Blog toDomainModel() {
        return new Blog(
                UUID.fromString(id).toString(),
                title,
                body
        );
    }
}
