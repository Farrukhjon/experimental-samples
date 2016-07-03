import * as _ from "lodash";

import $ from "jquery";

function f() {
    $.each([1, 2, 3], function (indexInArray) {
        console.log(indexInArray);
    });
}

f();

function changeToSnakeCase(param:string) {
    let snakeCase = _.snakeCase(param);
    console.log(snakeCase);
    return snakeCase;
}

function changeToCamelCase(param:string) {
    let snakeCase = _.camelCase(param);
    console.log(snakeCase);
}

let snake_case = changeToSnakeCase('Hello world');
changeToCamelCase(snake_case);