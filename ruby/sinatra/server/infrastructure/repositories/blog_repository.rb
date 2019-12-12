module Infrastructure
  module Repositories
    class BlogRepository < Domain::Blog::BlogRepository
      def initialize(model = {})
        @blog = model.fetch(:blog) { Domain::Blog::Blog }
      end

      def save(blog)
        blog.save
      end

      def find_by_id(id)
        @blog.find_by(id: id)
      end
    end
  end
end