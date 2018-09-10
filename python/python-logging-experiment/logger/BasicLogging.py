
from logger.LoggerConfig import LoggerConfig

class MyLoggedObject(object):

    def __init__(self):
        config = LoggerConfig()
        self.__logger__ = config.configureLogger()

    def doSomething(self):
        aVar = 'Hello'
        self.__logger__.info('Doing something... %s:', aVar)


loggedObj = MyLoggedObject()
loggedObj.doSomething()

