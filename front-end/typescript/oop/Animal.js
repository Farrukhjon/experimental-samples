var Animal = (function () {
    function Animal(name) {
        this._name = '[Some Animal]'; // type inference is working for name property depending from value '[Some Animal]'
        this._name = name;
    }
    Object.defineProperty(Animal.prototype, "name", {
        get: function () {
            return this._name;
        },
        set: function (value) {
            this._name = value;
        },
        enumerable: true,
        configurable: true
    });
    Animal.prototype.sayName = function () {
        console.log("My name is " + this.name);
    };
    return Animal;
}());
//# sourceMappingURL=Animal.js.map