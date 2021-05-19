package com.phodal.layer.application.infrastructure.persistence;

import com.phodal.layer.application.domain.blog.Blog;
import com.phodal.layer.application.domain.blog.BlogRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class BlogRepositoryImpl implements BlogRepository {
    private final BlogMapper blogMapper;

    public BlogRepositoryImpl(BlogMapper blogMapper) {
        this.blogMapper = blogMapper;
    }

    @Override
    public void save(Blog blog) {
        var blogPO = BlogPO.of(blog);

        blogMapper.findById(blog.getId()).ifPresentOrElse(
                po -> blogMapper.update(blogPO),
                () -> blogMapper.insert(blogPO)
        );
    }

    @Override
    public Optional<Blog> findById(String id) {
        return blogMapper.findById(id).map(BlogPO::toDomainModel);
    }
}
