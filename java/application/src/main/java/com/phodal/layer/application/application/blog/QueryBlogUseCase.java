package com.phodal.layer.application.application.blog;

import com.phodal.layer.application.domain.blog.Blog;
import com.phodal.layer.application.domain.blog.BlogRepository;
import com.phodal.layer.application.domain.blog.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueryBlogUseCase {
    private final BlogService blogService;
    private final BlogRepository blogRepository;

    @Autowired
    public QueryBlogUseCase(BlogRepository blogRepository) {
        // 依赖注入是一种应用需要和技术实现细节，所以在 UseCase 里使用依赖注入框架，通过实例化 DomainService 并注入相关依赖的方式实现了 Domain 与技术框架的解耦。
        this.blogService = new BlogService(blogRepository);
        this.blogRepository = blogRepository;
    }

    public Blog get(String id) {
        return blogService.get(id);
    }
}
