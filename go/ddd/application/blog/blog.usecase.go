package blog

import (
	"context"
	"ddd/domain/blog"
)

type BlogUsecase struct {
	Repository blog.BlogRepository
}

// GetUser returns user
func (i BlogUsecase) GetBlog(ctx context.Context, id int) (*blog.Blog, error) {
	return i.Repository.Get(ctx, id)
}

// AddUser saves new user
func (i BlogUsecase) AddBlog(ctx context.Context, title string, content string) error {
	u, err := blog.NewBlog(title, content)
	if err != nil {
		return err
	}
	return i.Repository.Save(ctx, u)
}