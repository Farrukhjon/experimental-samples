"use strict";
var Environment = (function () {
    function Environment(id, name) {
        this.id = id;
        this.name = name;
    }
    Environment.prototype.getProperties = function () {
        return this.id + " : " + this.name;
    };
    return Environment;
}());
exports.Environment = Environment;
var serverEnv = new Environment(80, 'port');
console.log(serverEnv);
//# sourceMappingURL=environment.js.map