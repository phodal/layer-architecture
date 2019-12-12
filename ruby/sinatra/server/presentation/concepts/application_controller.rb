require 'sinatra'
require 'sinatra/json'
require 'rack/protection'

module Presentation
  module Controller
    # Base controller, handles the default route
    class ApplicationController < Sinatra::Application
      use Rack::Deflater
      use Rack::Protection
    end
  end
end
