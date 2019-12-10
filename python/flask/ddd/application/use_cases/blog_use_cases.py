from ddd.shared import use_case as uc
from ddd.shared import response_object as res


class CreateBlogUseCases(uc.UseCase):
    def __init__(self, repo):
        self.repo = repo

    def process_request(self, request_object):
        blog = self.repo.get_blog_by_id(0)
        return res.ResponseSuccess(blog)
