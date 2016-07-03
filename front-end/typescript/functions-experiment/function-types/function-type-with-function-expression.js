function RegularFunction(param) {
    return param;
}
var varDeclaredAsFunctionTypes; // variable declared as function types.
varDeclaredAsFunctionTypes = RegularFunction;
var someVar = varDeclaredAsFunctionTypes("Hello world!");
console.log(someVar);
//# sourceMappingURL=function-type-with-function-expression.js.map