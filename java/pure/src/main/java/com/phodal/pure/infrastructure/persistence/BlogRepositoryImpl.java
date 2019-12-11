package com.phodal.pure.infrastructure.persistence;

import com.phodal.pure.domain.blog.Blog;
import com.phodal.pure.domain.blog.BlogRepository;

import java.util.Optional;

public class BlogRepositoryImpl implements BlogRepository {
    @Override
    public void save(Blog blog) {

    }

    @Override
    public Optional<Blog> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Blog createBlog(String title, String content) {
        return new Blog(title, content);
    }
}
