package com.phodal.pure.infrastructure.persistence;

import com.phodal.pure.domain.blog.Blog;
import com.phodal.pure.domain.blog.BlogRepository;

import java.util.HashMap;
import java.util.Optional;

public class BlogRepositoryImpl implements BlogRepository {
    HashMap<String, Blog> map = new HashMap<String, Blog>();

    @Override
    public void save(Blog blog) {
        map.put(blog.getId(), blog);
    }

    @Override
    public Optional<Blog> findById(String id) {
        Blog blog = map.get(id);
        return Optional.of(blog);
    }
}
