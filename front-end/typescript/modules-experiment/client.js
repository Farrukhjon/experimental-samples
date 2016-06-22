"use strict";
var math_1 = require("./math");
var util = require("./util");
var cal = new math_1.Calc();
var printer = new util.Printer();
for (var i = 0; i < 10; i++) {
    var result = cal.add(i, i + 1);
    console.log(printer.print(result));
}
//# sourceMappingURL=client.js.map