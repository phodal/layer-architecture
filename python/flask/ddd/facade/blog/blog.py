import json

from flask import Blueprint, jsonify, request, Response

from . import create_blog_request as req
from ddd.facade.status_code import STATUS_CODES
from ddd.application.use_cases.blog_use_cases import CreateBlogUseCases
from ddd.infrastructure.repository import memrepo as mr

blueprint = Blueprint('blog', __name__)

repo = mr.MemRepo()


@blueprint.route('/blog', methods=['GET'])
def get_blog():
    return Response(json.dumps([ob.__dict__ for ob in repo.list()]),
                    mimetype='application/json',
                    status=STATUS_CODES[200])


@blueprint.route('/blog', methods=['POST'])
def create_blog():
    content = request.json
    request_object = req.CreateBlogRequest.from_dict(content)

    usecases = CreateBlogUseCases(repo)
    response = usecases.execute(request_object)

    return Response(json.dumps(response.value),
                    mimetype='application/json',
                    status=STATUS_CODES[response.type])
