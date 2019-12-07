package com.phodal.layer.application.domain.blog;

import com.phodal.layer.application.infrastructure.concept.BaseRepository;

import java.util.Optional;

public interface BlogRepository extends BaseRepository {
    void save(Blog blog);
    Optional<Blog> findById(String id);
}
