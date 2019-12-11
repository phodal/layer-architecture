package com.phodal.pure;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.phodal.pure.domain.blog.Blog;
import com.phodal.pure.domain.blog.BlogRepository;

public class Application {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new BlogModule());
        BlogRepository repository = injector.getInstance(BlogRepository.class);

        Blog blog = new Blog("title", "content");
        repository.save(blog);

        String id = blog.getId();
        repository.findById(id).ifPresent(
                blog1 -> {
                    System.out.println(blog1.getId());
                }
        );
    }
}
