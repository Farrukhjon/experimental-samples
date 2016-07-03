interface ISquare {
    square:(x:number) => number;
    show:(x) => void;
}

//Implementing ISquare interface to the square object.
let squareObj:ISquare = {
    square: num => num * num,
    show: x => console.log(x)
};

[1, 2, 3].forEach(x => squareObj.show(squareObj.square(x)));

