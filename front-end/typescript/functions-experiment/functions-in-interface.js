//Implementing ISquare interface to the square object.
var squareObj = {
    square: function (num) { return num * num; },
    show: function (x) { return console.log(x); }
};
[1, 2, 3].forEach(function (x) { return squareObj.show(squareObj.square(x)); });
//# sourceMappingURL=functions-in-interface.js.map