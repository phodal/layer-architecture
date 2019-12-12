# frozen_string_literal: true

root = File.expand_path(File.join(__dir__, '..'))
$LOAD_PATH.unshift File.join(root, 'server')

require 'infrastructure/log/loggable'

configure :development, :production do
  enable :static
  enable :logging
  enable :sessions
  enable :protection
  disable :method_override
  disable :run

  set :sessions,
      httponly: true,
      secure: production?,
      expire_after: 31_557_600, # 1 year
      secret: ENV['SESSION_SECRET']
  set :session_store, Rack::Session::Pool
  set :ssl, production?
end

configure :development do
  enable :show_exceptions
  enable :raise_errors
end

configure :production do
  disable :show_exceptions
  disable :raise_errors
end

configure :test do
  enable :logging
  enable :show_exceptions
  enable :raise_errors
  enable :sessions
end
