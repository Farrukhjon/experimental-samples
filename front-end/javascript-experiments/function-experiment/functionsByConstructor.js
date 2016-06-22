var constructedFunction = new Function('a', 'b', "return a*b");

var tmp = constructedFunction(3, 4);
console.log(tmp);