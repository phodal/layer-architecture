# frozen_string_literal: true

require 'sinatra'
require_relative 'config/environment.rb'

require 'presentation/master_site_controller'

use Rack::Reloader unless settings.production?

map('/') { run Presentation::Controller::MasterSiteController }