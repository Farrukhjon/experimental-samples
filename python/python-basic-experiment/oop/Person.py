class Person:
    def __init__(self, firstName, lastName):
        self.fistName = firstName
        self.lastName = lastName

    def __str__(self):
        return "firstName: {}, lastName: {}".format(self.fistName, self.lastName)


ali = Person('Ali', 'Valiev')

print(ali)
