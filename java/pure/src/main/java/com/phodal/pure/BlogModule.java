package com.phodal.pure;

import com.google.inject.AbstractModule;
import com.phodal.pure.domain.blog.BlogRepository;
import com.phodal.pure.infrastructure.persistence.BlogRepositoryImpl;

public class BlogModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(BlogRepository.class).to(BlogRepositoryImpl.class);
    }
}
