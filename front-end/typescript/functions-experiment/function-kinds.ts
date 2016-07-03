function namedFunction() {
    console.log("Just shows declare and call named function");
}

namedFunction();

let anonymousFunction = function (x, y) {
    return x * y;
};

var result = anonymousFunction(2, 2);
console.log(result);