/// <reference path="calculator.ts"/>

var result  = Calculator.BasicCalculator.add(5, 7);
console.log(`The result of the Calculator.BasicCalculator.add(a, b) is ${result}`);

var result2 = Calculator.AdvancedCalculator.add(1, 2, 3);
console.log(`The result of the Calculator.AdvancedCalculator.add(a, b, c) is ${result2}`);
