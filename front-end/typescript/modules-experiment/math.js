"use strict";
var Calculator = (function () {
    function Calculator() {
    }
    Calculator.prototype.add = function (a, b) {
        return a + b;
    };
    return Calculator;
}());
exports.Calc = Calculator;
var AdvancedCalculator = (function () {
    function AdvancedCalculator() {
    }
    return AdvancedCalculator;
}());
exports.AdvancedCalculator = AdvancedCalculator;
function factorial(n) {
    return n;
}
exports.factorial = factorial;
//# sourceMappingURL=math.js.map