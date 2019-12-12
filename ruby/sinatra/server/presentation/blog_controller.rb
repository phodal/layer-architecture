require 'presentation/concepts/application_controller'
require 'domain/blog/blog'

module Presentation
  module Controller
    # Controller that handles requests about Person-related actions
    class BlogController < ApplicationController
      def initialize(app, blog = Domain::Blog.new)
        super app
        @blog = blog
      end

      get '/blog' do
        json @blog.all.map(&:to_hash)
      end
    end
  end
end
