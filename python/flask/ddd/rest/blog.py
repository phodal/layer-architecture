from flask import Blueprint, request, Response

blueprint = Blueprint('blog', __name__)


@blueprint.route('/blog', methods=['GET'])
def get_blog():
    return
