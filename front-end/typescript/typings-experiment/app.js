"use strict";
var _ = require("lodash");
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