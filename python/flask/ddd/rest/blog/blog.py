import json

from flask import Blueprint, jsonify, request, Response

from . import create_blog_request as req
from ..status_code import STATUS_CODES
from ...shared import use_case

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
    re = req.CreateBlogRequest.from_dict(content)

    response = use_case.execute(re)

    return Response(json.dumps(response.value),
                    mimetype='application/json',
                    status=STATUS_CODES[response.type])
