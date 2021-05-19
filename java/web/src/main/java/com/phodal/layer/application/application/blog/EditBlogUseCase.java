package com.phodal.layer.application.application.blog;

import com.phodal.layer.application.domain.blog.Blog;
import com.phodal.layer.application.domain.blog.BlogRepository;
import com.phodal.layer.application.domain.blog.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class EditBlogUseCase {
    private final BlogService blogService;

    @Autowired
    public EditBlogUseCase(BlogRepository blogRepository) {
        // 依赖注入是一种应用需要和技术实现细节，所以在 UseCase 里使用依赖注入框架，通过实例化 DomainService 并注入相关依赖的方式实现了 Domain 与技术框架的解耦。
        this.blogService = new BlogService(blogRepository);
    }

    // 从单纯的整洁代码角度来说，这种简单的代理（或委托）代码是一种坏味道，但是由于事务注解的存在（应用需要和技术实现细节），所以是一种可以接受的坏味道。
    @Transactional
    public Blog create(String title, String body) {
        return blogService.create(title, body);
    }
}

