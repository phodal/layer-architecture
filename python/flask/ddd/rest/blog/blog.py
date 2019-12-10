import json

from flask import Blueprint, jsonify, request, Response

from . import create_blog_request as req
from ddd.rest.status_code import STATUS_CODES
from ddd.application.use_cases.blog_use_cases import CreateBlogUseCases
from ddd.infrastructure.repository import memrepo as mr


blueprint = Blueprint('blog', __name__)

blog = {
    'id': 'f853578c-fc0f-4e65-81b8-566c5dffa35a',
    'title': "this is a title",
    'content': "this is a content"
}


@blueprint.route('/blog', methods=['GET'])
def get_blog():
    return jsonify(blog)


@blueprint.route('/blog', methods=['POST'])
def create_blog():
    content = request.json
    request_object = req.CreateBlogRequest.from_dict(content)

    repo = mr.MemRepo([blog])

    usecases = CreateBlogUseCases(repo)
    response = usecases.execute(request_object)

    return Response(json.dumps(response.value),
                    mimetype='application/json',
                    status=STATUS_CODES[response.type])
