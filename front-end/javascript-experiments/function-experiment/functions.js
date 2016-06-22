function myDeclaredFunction() {
    console.log("Hello world");
}
myDeclaredFunction();

(function () {
    for (var i = 0; i < 10; i++) {
        console.log(i)
    }
})();

var myFunctionExpression = function (a, b) {
    console.log(a + b)
};

myFunctionExpression(1, 2);

var constructedFunction = new Function('a', 'b', "return a*b");

var tmp = constructedFunction(3, 4);
console.log(tmp);

callBefore(7);

function callBefore(number) {
    console.log(number * number);
}
