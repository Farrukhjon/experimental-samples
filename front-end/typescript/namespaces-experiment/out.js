var Calculator;
(function (Calculator) {
    // nested namespace
    var BasicCalculator;
    (function (BasicCalculator) {
        function add(a, b) {
            return a + b;
        }
        BasicCalculator.add = add;
    })(BasicCalculator = Calculator.BasicCalculator || (Calculator.BasicCalculator = {}));
    // nested namespace
    var AdvancedCalculator;
    (function (AdvancedCalculator) {
        function add(a, b, c) {
            return a + b + c;
        }
        AdvancedCalculator.add = add;
    })(AdvancedCalculator = Calculator.AdvancedCalculator || (Calculator.AdvancedCalculator = {}));
    // private function within this namespace
    function privateFunction() {
        console.log("Invoking the private function which is within in this (Calculator) namespace...");
    }
    privateFunction();
})(Calculator || (Calculator = {}));
/// <reference path="calculator.ts"/>
var basicCalc = Calculator.BasicCalculator;
var advCalc = Calculator.AdvancedCalculator;
var result = basicCalc.add(5, 7);
console.log("The result of the Calculator.BasicCalculator.add(a, b) is " + result);
var result2 = advCalc.add(1, 2, 3);
console.log("The result of the Calculator.AdvancedCalculator.add(a, b, c) is " + result2);
/// <reference path="calculator.ts"/>
var result = Calculator.BasicCalculator.add(5, 7);
console.log("The result of the Calculator.BasicCalculator.add(a, b) is " + result);
var result2 = Calculator.AdvancedCalculator.add(1, 2, 3);
console.log("The result of the Calculator.AdvancedCalculator.add(a, b, c) is " + result2);
//# sourceMappingURL=out.js.map