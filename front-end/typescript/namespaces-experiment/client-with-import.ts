/// <reference path="calculator.ts"/>

import basicCalc = Calculator.BasicCalculator;
import advCalc = Calculator.AdvancedCalculator;

var result  = basicCalc.add(5, 7);
console.log(`The result of the Calculator.BasicCalculator.add(a, b) is ${result}`);

var result2 = advCalc.add(1, 2, 3);
console.log(`The result of the Calculator.AdvancedCalculator.add(a, b, c) is ${result2}`);
