import os


def test_multiple_framework():
    global application
    try:
        # try importing Python debugger package for use with Visual Studio Code
        import ptvsd

        ptvsd.enable_attach(address=('0.0.0.0', 3000))
    except:
        print('ptvsd disabled')
    framework = os.environ.get('FRAMEWORK', 'flask')
    print('Running {} app'.format(framework))
    application = None  # required by gunicorn
    if framework == 'falcon':
        from ddd.infrastructure.framework.falcon.app import app as application
    elif framework == 'flask':
        from ddd.infrastructure.framework.flask.app import app as application
    application.run()


# test_multiple_framework()

from ddd.app import create_app

app = create_app()
app.run()
