function RegularFunction(param:string):string {
    return param;
}

let varDeclaredAsFunctionTypes:(someParam:string) => string; // variable declared as function types.

varDeclaredAsFunctionTypes = RegularFunction;

let someVar:string = varDeclaredAsFunctionTypes("Hello world!");

console.log(someVar);