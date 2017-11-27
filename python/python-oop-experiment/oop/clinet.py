# importing module:
# 1. import oop.oopModule
from oop.oopModule import Engine

# or use below syntax:
from oop import oopModule

engine = Engine("Eng_123")

opel = oopModule.Auto('Opel Astra G', engine)

print opel

opel.move()

