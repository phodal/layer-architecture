from ddd.domain import blog as sr


class MemRepo:

    def __init__(self, entries=None):
        self._entries = []
        if entries:
            self._entries.extend(entries)

    def get_blog_by_id(self, index):
        result = self._entries[index]
        return result

    def add_blog(self, obj):
        self._entries.append(obj)

    def list(self):
        return self._entries
