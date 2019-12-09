package persistence

import (
	"context"
	"database/sql"
	"ddd/domain/blog"
	_ "github.com/go-sql-driver/mysql" // driver
)

type blogRepositoryImpl struct {
	conn *sql.DB
}

func NewBlogRepository(conn *sql.DB) blog.BlogRepository {
	return &blogRepositoryImpl{conn: conn}
}

func (r blogRepositoryImpl) Get(ctx context.Context, id int) (*blog.Blog, error) {
	row, err := r.queryRow(ctx, "select id, title, content from blog where id=?", id)
	if err != nil {
		return nil, err
	}
	u := &blog.Blog{}
	err = row.Scan(&u.ID, &u.Title, &u.Content)
	if err != nil {
		return nil, err
	}
	return u, nil
}

// Save saves domain.User to storage
func (r *blogRepositoryImpl) Save(ctx context.Context, u *blog.Blog) error {
	stmt, err := r.conn.Prepare("insert into blog(title, content) values (?, ?)")
	if err != nil {
		return err
	}
	defer stmt.Close()

	_, err = stmt.ExecContext(ctx, u.Title, u.Content)
	return err
}

func (r *blogRepositoryImpl) queryRow(ctx context.Context, q string, args ...interface{}) (*sql.Row, error) {
	stmt, err := r.conn.Prepare(q)
	if err != nil {
		return nil, err
	}
	defer stmt.Close()

	return stmt.QueryRowContext(ctx, args...), nil
}
