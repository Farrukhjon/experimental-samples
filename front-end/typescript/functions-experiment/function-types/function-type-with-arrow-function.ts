let var2DeclaredAsFunctionTypes:(someParam:string) => string;

var2DeclaredAsFunctionTypes = (param:string) => {
    return param;
};

let someVar2:string = var2DeclaredAsFunctionTypes("Hello world!");

console.log(someVar2);