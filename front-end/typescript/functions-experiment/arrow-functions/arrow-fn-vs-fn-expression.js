"use strict";
// Arrow function vs Function Expression
// Case in a class.
var SomeClass = (function () {
    function SomeClass() {
        this.someProperty = 'Some Value';
    }
    SomeClass.prototype.functionExpression = function () {
        setTimeout(function () {
            console.log(this.someProperty);
        }, 100);
    };
    SomeClass.prototype.arrowFunction = function () {
        var _this = this;
        setTimeout(function () {
            console.log(_this.someProperty);
        }, 100);
    };
    return SomeClass;
}());
exports.SomeClass = SomeClass;
var someObject = new SomeClass();
someObject.functionExpression(); // call result prints 'undefined'
someObject.arrowFunction(); // call result prints 'Some value'
//# sourceMappingURL=arrow-fn-vs-fn-expression.js.map