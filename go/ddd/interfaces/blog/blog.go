package blog

import (
	applicationBlog "ddd/application/blog"
	domainBlog "ddd/domain/blog"
	"encoding/json"
	"fmt"
	router "github.com/takashabe/go-router"
	"log"
	"net/http"
)

type Handler struct {
	Repository domainBlog.BlogRepository
}

// Routes returns the initialized router
func (h Handler) Routes() *router.Router {
	r := router.NewRouter()
	r.Get("/user/:id", h.getBlog)
	r.Post("/user", h.createBlog)
	return r
}

// Run start server
func (h Handler) Run(port int) error {
	log.Printf("Server running at http://localhost:%d/", port)
	return http.ListenAndServe(fmt.Sprintf(":%d", port), h.Routes())
}

func (h Handler) getBlog(w http.ResponseWriter, r *http.Request, id int) {
	ctx := r.Context()

	usecase := applicationBlog.BlogUsecase{
		Repository: h.Repository,
	}
	user, err := usecase.GetBlog(ctx, id)
	if err != nil {
		Error(w, http.StatusNotFound, err, "failed to get user")
		return
	}
	JSON(w, http.StatusOK, user)
}

func (h Handler) createBlog(w http.ResponseWriter, r *http.Request) {
	ctx := r.Context()

	type payload struct {
		Title   string `json:"title"`
		Content string `json:"content"`
	}
	var p payload
	if err := json.NewDecoder(r.Body).Decode(&p); err != nil {
		Error(w, http.StatusBadRequest, err, "failed to parse request")
		return
	}

	interactor := applicationBlog.BlogUsecase{
		Repository: h.Repository,
	}

	if err := interactor.AddBlog(ctx, p.Title, p.Content); err != nil {
		Error(w, http.StatusInternalServerError, err, "failed to create user")
		return
	}
	JSON(w, http.StatusCreated, nil)
}
