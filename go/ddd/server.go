package main

import (
	"database/sql"
	"ddd/infrastructure/persistence"
	"ddd/interfaces/blog"
	_ "github.com/go-sql-driver/mysql"
	"log"
)

func main() {
	db, err := sql.Open("mysql",
		"root:password@tcp(127.0.0.1:3306)/blog")
	if err != nil {
		log.Fatal(err)
	}
	defer db.Close()

	repo := persistence.NewBlogRepository(db)
	handler := &blog.Handler{Repository: repo}
	_ = handler.Run(8080)
}
