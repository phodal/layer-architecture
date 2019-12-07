package com.phodal.layer.application.domain.blog;

import com.phodal.layer.application.domain.blog.exception.NoSuchBlogException;

public class BlogService {
    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public Blog get(String id) {
        return blogRepository.findById(id).orElseThrow(() -> new NoSuchBlogException(Blog.class, id));
    }
}
