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
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.body = body;
    }


}
