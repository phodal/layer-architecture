# frozen_string_literal: true

module Application
  module Blog
    class BlogApplication
      def initialize(repositories = {})
        @blog_repository = repositories.fetch(:blog) { Infrastructure::Repositories::BlogRepository.new }
      end

    end
  end
end