package com.phodal.layer.application.domain.blog.exception;

import com.phodal.layer.application.domain.blog.Blog;
import com.phodal.layer.application.infrastructure.concept.exception.DomainException;

import java.util.UUID;

public class NoSuchBlogException extends DomainException {
    public NoSuchBlogException(Class<Blog> blogClass, String id) {
        super("no such blog {}" + id);
    }
}
