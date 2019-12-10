import falcon

from ddd.facade.blog import blog


def error_serializer(req, resp, exception):
    preferred = req.client_prefers(('application/json'))
    if preferred is not None:
        representation = exception.to_json()

        resp.body = representation
        resp.content_type = preferred
    resp.append_header('Vary', 'Accept')


def create_app():
    app = falcon.API()
    app.set_error_serializer(error_serializer)
    app.add_route("/blog", blog.get_blog())
    return app
