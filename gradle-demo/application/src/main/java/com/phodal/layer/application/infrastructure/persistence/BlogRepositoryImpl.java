package com.phodal.layer.application.infrastructure.persistence;

import com.phodal.layer.application.domain.blog.Blog;
import com.phodal.layer.application.domain.blog.BlogRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class BlogRepositoryImpl implements BlogRepository {
    @Override
    public void save(Blog blog) {

    }

    @Override
    public Optional<Blog> findById(String id) {
        return Optional.empty();
    }
}
