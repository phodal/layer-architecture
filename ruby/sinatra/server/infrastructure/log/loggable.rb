# frozen_string_literal: true

require 'logging'
require 'forwardable'

# Logger configurations module
module Logging
  Logging.color_scheme('custom',
                       levels: {
                           info: :white,
                           warn: :yellow,
                           debug: :green,
                           error: :red,
                           fatal: %i[yellow on_red]
                       },
                       date: :blue,
                       logger: :cyan,
                       message: :magenta)

  Logging.appenders.stdout(
      'stdout',
      layout: Logging.layouts.pattern(
          pattern: '[%d] level=%-5l artifact=%c -> %m\n',
          color_scheme: 'custom'
      )
  )

  Logging.logger.root.level = ENV['LOG_LEVEL'] || :info

  # Methods to wrap logger. Include this whenever logs are required
  module Loggable
    extend Forwardable

    def_delegator :logger, :debug, :log_debug
    def_delegator :logger, :info, :log_info
    def_delegator :logger, :warn, :log_warn
    def_delegator :logger, :error, :log_error
    def_delegator :logger, :fatal, :log_fatal

    def logger
      @logger ||= Logging.logger[self].add_appenders 'stdout'
    end
  end
end