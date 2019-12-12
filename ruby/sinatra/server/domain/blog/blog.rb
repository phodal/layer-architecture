# frozen_string_literal: true
module Domain
  class Blog
    attribute :id, :title, :content

    def validate_title!
      unless title.present?
        raise Exceptions::BusinessException, 'Product must be greater than zero'
      end
    end

    def validate
      validate_title!
    end

    def to_hash
      {
          id: id,
          title: title,
          content: content
      }
    end

    alias to_h to_hash
  end
end
