import os

global application
try:
    # try importing Python debugger package for use with Visual Studio Code
    import ptvsd

    ptvsd.enable_attach(address=('0.0.0.0', 3000))
except:
    print('ptvsd disabled')
framework = os.environ.get('FRAMEWORK', 'falcon')
print('Running {} app'.format(framework))
application = None  # required by gunicorn
if framework == 'falcon':
    from ddd.infrastructure.framework.falcon.app import create_app
    application = create_app()
elif framework == 'flask':
    from ddd.infrastructure.framework.flask.app import create_app
    application = create_app()

application.run()
