class Machine(object):
    def __init__(self, name=None):
        self.name = name

    def __str__(self):  # Pre-Defining str method
        return self.name


class Engine(object):
    def __init__(self, name=None):
        self.name = name

    def __run__(self):
        print "Running... by engine {}".format(self.name)


class Auto(Machine):
    version = '1.0'  # class level variable. It is shared across all possible instances

    def __init__(self, name=None, engine=None):
        super(Auto, self).__init__(name)
        self.engine = engine

    def move(self):
        self.engine.__run__()

    def __str__(self, name=None):  # Overriding str method
        return "Auto: " + super(Auto, self).__str__() + ", version: {}".format(Auto.version)
