var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
var Car = (function () {
    function Car(model, motor) {
        this.model = model;
        this.motor = motor;
    }
    return Car;
}());
var Opel = (function (_super) {
    __extends(Opel, _super);
    function Opel(model, motor) {
        _super.call(this, model, motor);
    }
    Opel.prototype.start = function () {
        return "starting car, model: " + this.model + " motor is " + this.motor;
    };
    return Opel;
}(Car));
var car = new Opel("653", 3);
//# sourceMappingURL=Car.js.map