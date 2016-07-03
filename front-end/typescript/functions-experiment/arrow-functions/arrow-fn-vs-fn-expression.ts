// Arrow function vs Function Expression
// Case in a class.
export class SomeClass {

    someProperty = 'Some Value';

    functionExpression() {
        setTimeout(function () {
            console.log(this.someProperty);
        }, 100);
    }

    arrowFunction() {
        setTimeout(() => {
            console.log(this.someProperty);
        }, 100);
    }

}

let someObject = new SomeClass();

someObject.functionExpression(); // call result prints 'undefined'
someObject.arrowFunction(); // call result prints 'Some value'
