var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
var SomeClass = (function () {
    function SomeClass() {
        var _this = this;
        this.arrowFunctionProperty = function () {
            console.log("this is: " + _this); // It references to the generated `_this` property. Which is created like `_this = this;`
        };
    }
    SomeClass.prototype.regularMethod = function () {
        console.log("this is: " + this); // It references `this`.
    };
    return SomeClass;
}());
var someObject = new SomeClass();
someObject.regularMethod();
someObject.arrowFunctionProperty();
// Demo of inheritance downside of arrow function property.
var SomeChildClass = (function (_super) {
    __extends(SomeChildClass, _super);
    function SomeChildClass() {
        _super.apply(this, arguments);
    }
    SomeChildClass.prototype.childMethod1 = function () {
        // super.arrowFunctionProperty(); Does not work!
    };
    SomeChildClass.prototype.childMethod2 = function () {
        _super.prototype.regularMethod.call(this); // It works.
    };
    return SomeChildClass;
}(SomeClass));
//# sourceMappingURL=arrow-fn-as-properties.js.map