package com.phodal.pure.domain.blog;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class Blog {
    private String id;
    private String title;
    private String body;

    public Blog(String title, String body) {
        if (title == null || title.equals("")) {
            throw new IllegalArgumentException("the title cannot be null or no content");
        }


        if (body == null || body.equals("")) {
            throw new IllegalArgumentException("the title cannot be null or no content");
        }

        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.body = body;
    }
}
