class SomeClass {

    arrowFunctionProperty = () => {
        console.log(`this is: ${this}`); // It references to the generated `_this` property. Which is created like `_this = this;`
    };

    regularMethod() {
        console.log(`this is: ${this}`); // It references `this`.
    }
}

let someObject = new SomeClass();

someObject.regularMethod();
someObject.arrowFunctionProperty();


// Demo of inheritance downside of arrow function property.
class SomeChildClass extends SomeClass {
    
    
    childMethod1() {
        // super.arrowFunctionProperty(); Does not work!
    }
    
    childMethod2() {
        super.regularMethod(); // It works.
    }
    
}