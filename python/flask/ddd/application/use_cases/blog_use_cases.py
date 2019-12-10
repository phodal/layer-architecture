import uuid

from ddd.shared import use_case as uc
from ddd.shared import response_object as res


class CreateBlogUseCases(uc.UseCase):
    def __init__(self, repo):
        self.repo = repo

    def process_request(self, model):
        blog_id = uuid.uuid4().__str__()
        model.id = blog_id
        self.repo.add_blog(model)
        return res.ResponseSuccess(blog_id)
