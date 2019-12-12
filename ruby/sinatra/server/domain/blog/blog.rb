module Domain
  class Blog
    attr_accessor :id, :title, :content

    def initialize(id = nil, title = nil, content = nil)
      @id = id
      @title = title
      @content = content
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
