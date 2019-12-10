from flask import Flask

from ddd.rest.blog import blog
from ddd.settings import DevConfig


def create_app(config_object=DevConfig):
    app = Flask(__name__)
    app.config.from_object(config_object)
    app.register_blueprint(blog.blueprint)
    return app
