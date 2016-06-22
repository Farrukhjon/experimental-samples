var LambdaDemo = (function () {
    function LambdaDemo() {
        this.list = [0, 1, 2, 3, 4, 5];
    }
    LambdaDemo.prototype.print = function () {
        this.list.forEach(function (item) {
            console.log(item);
        });
    };
    LambdaDemo.prototype.get = function () {
        return this.list;
    };
    return LambdaDemo;
}());
var lam = new LambdaDemo();
//# sourceMappingURL=Lambda.js.map