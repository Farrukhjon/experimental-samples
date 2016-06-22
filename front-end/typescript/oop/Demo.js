var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
var Demo;
(function (Demo) {
    var Dog = (function (_super) {
        __extends(Dog, _super);
        function Dog() {
            _super.apply(this, arguments);
        }
        Dog.prototype.bark = function () {
            console.log("Woof!");
        };
        return Dog;
    }(Animal));
    Demo.Dog = Dog;
})(Demo || (Demo = {}));
var animal = new Demo.Dog('Rex');
animal.sayName();
animal.bark();
//# sourceMappingURL=Demo.js.map