from ddd.shared import use_case as uc
from ddd.shared import response_object as res


class BlogUseCases(uc.UseCase):
    def __init__(self, repo):
        self.repo = repo

    def process_request(self, request_object):
        # blog = self.repo.list(filters=request_object.filters)
        return res.ResponseSuccess("")
