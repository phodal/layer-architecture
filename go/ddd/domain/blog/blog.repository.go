package blog

import "context"

type BlogRepository interface {
	Get(ctx context.Context, id int) (*Blog, error)
	Save(ctx context.Context, user *Blog) error
}
