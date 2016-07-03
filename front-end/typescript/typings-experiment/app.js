"use strict";
var _ = require("lodash");
var jquery_1 = require("jquery");
function f() {
    jquery_1.default.each([1, 2, 3], function (indexInArray) {
        console.log(indexInArray);
    });
}
f();
function changeToSnakeCase(param) {
    var snakeCase = _.snakeCase(param);
    console.log(snakeCase);
    return snakeCase;
}
function changeToCamelCase(param) {
    var snakeCase = _.camelCase(param);
    console.log(snakeCase);
}
var snake_case = changeToSnakeCase('Hello world');
changeToCamelCase(snake_case);
//# sourceMappingURL=app.js.map