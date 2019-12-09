package blog

import "fmt"

type Blog struct {
	ID      int    `json:"id"`
	Title   string `json:"title"`
	Content string `json:"content"`
}

func NewBlog(title string, content string) (*Blog, error) {
	if title == "" {
		return nil, fmt.Errorf("invalid title")
	}

	if content == "" {
		return nil, fmt.Errorf("invalid content")
	}

	return &Blog{
		ID:      0,
		Title:   title,
		Content: content,
	}, nil
}
