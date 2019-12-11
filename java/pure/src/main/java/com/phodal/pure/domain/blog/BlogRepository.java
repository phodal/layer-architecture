package com.phodal.pure.domain.blog;

import com.phodal.pure.infrastructure.concept.BaseRepository;

import java.util.Optional;

public interface BlogRepository extends BaseRepository {
    void save(Blog blog);
    Optional<Blog> findById(String id);
}

