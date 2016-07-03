export interface ICalculator {

    add:(a:number, b:number) => number;

    print:(param:string) => void;

    multiple:(a:number, b:number) => number;

    getObject:() => {};

}

export class Calculator implements ICalculator {

    add = function (a, b) {
        return a + b;
    };

    print = (param:string) => {
        console.log(param);
    };

    multiple = (a:number, b:number)=> {
        return a * b;
    };

    getObject:() => {};

}

let calc = new Calculator();

console.log(calc.add(1, 2));

calc.print("Hello world!");

console.log(calc.multiple(2, 5));
