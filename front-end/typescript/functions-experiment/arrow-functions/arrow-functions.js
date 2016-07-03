var f1 = function (a) {
    console.log("call from f1, arg value is " + a);
    // return undefined ?
};
var f2 = function (a) { return a + 1; };
var returnValue = f1(100);
console.log(returnValue);
var returnValue2 = f2(100);
console.log(returnValue2);
var sqrt = function (x) { return Math.sqrt(x); };
console.log(sqrt(16));
[25, 16, 4].forEach(function (x) {
    var number = Math.sqrt(x);
    console.log(number);
});
//# sourceMappingURL=arrow-functions.js.map