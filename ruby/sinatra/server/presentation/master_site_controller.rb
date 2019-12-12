# frozen_string_literal: true

require 'presentation/blog_controller'

module Presentation
  module Controller
    # Controller that handles requests about Person-related actions
    class MasterSiteController < ApplicationController
      use BlogController

      def initialize(blog = Domain::Blog.new)
        super
        @blog = blog
      end

      get '/' do
        p 200
      end

      # Check this. Aside of halting requests on non existent resources,
      # It prevents assets being searched in the controller routes,
      # Avoiding: RuntimeError - downstream app not set; 500
      get '/*' do
        halt 404, 'Not found'
      end
    end
  end
end