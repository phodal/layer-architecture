from flask import Flask

from .settings import DevConfig
from .rest import blog


def create_app(config_object=DevConfig):
    app = Flask(__name__)
    app.config.from_object(config_object)
    app.register_blueprint(blog.blueprint)
    return app
