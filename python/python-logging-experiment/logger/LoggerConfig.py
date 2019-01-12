import logging

logFile = 'logFile.log'
format = '%(message)s'


class LoggerConfig(object):

    def __init__(self):
        pass
    def configureLogger(self):
        logging.basicConfig(format=format,
                            level=logging.DEBUG,
                            filename=logFile)
        return logging
