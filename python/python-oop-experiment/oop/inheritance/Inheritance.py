import abc

from abc import abstractmethod


class AbstractSuperClass(object):
    __metaclass__ = abc.ABCMeta

    def __init__(self):
        pass

    def templateMethod(self):
        self.doSomething()

    @abstractmethod
    def doSomething(self):
        pass


class SubClassA(AbstractSuperClass):
    def __init__(self):
        super(SubClassA, self).__init__()

    def doSomething(self):
        print "Doing something.."


obj = SubClassA()
obj.templateMethod()

#  anObj.doSomething()
