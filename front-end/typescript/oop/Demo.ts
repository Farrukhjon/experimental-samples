module Demo {
    export class Dog extends Animal {
        bark() {
            console.log("Woof!");
        }
    }
}

var animal:IAnimal = new Demo.Dog('Rex');
animal.sayName();

(<Demo.Dog>animal).bark();