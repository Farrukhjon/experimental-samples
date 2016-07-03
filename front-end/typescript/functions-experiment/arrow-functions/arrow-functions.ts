let f1 = (a) => {
    console.log(`call from f1, arg value is ${a}`)
    // return undefined ?
};

let f2 = (a) => a + 1;

var returnValue = f1(100);
console.log(returnValue);

var returnValue2 = f2(100);
console.log(returnValue2);

let sqrt = x => Math.sqrt(x);

console.log(sqrt(16));

[25, 16, 4].forEach(x => {
    var number = Math.sqrt(x);
    console.log(number);
});

