"use strict";
var Calculator = (function () {
    function Calculator() {
        this.add = function (a, b) {
            return a + b;
        };
        this.print = function (param) {
            console.log(param);
        };
        this.multiple = function (a, b) {
            return a * b;
        };
    }
    return Calculator;
}());
exports.Calculator = Calculator;
var calc = new Calculator();
console.log(calc.add(1, 2));
calc.print("Hello world!");
console.log(calc.multiple(2, 5));
//# sourceMappingURL=calculator.js.map