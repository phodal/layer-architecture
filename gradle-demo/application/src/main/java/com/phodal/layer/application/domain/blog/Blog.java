package com.phodal.layer.application.domain.blog;

import com.phodal.layer.application.infrastructure.concept.AggregateRoot;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class Blog extends AggregateRoot {
    private String id;
    private String title;
    private String body;

    public Blog(String title, String body) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.body = body;
    }


}
