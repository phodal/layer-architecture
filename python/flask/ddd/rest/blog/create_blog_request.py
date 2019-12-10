from ddd.shared import request_object as req


class CreateBlogRequest(req.ValidRequestObject):
    def __init__(self, filters=None):
        self.filters = filters

    @classmethod
    def from_dict(cls, adict):
        invalid_req = req.InvalidRequestObject()

        if 'title' not in adict:
            invalid_req.add_error('title', 'lost')

        if invalid_req.has_errors():
            return invalid_req

        return CreateBlogRequest(filters=adict.get('filters', None))
