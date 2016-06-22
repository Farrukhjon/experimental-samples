class Car {
    constructor(public model:string, public motor:number) {
    }
}

class Opel extends Car {

    constructor(model:string, motor:number) {
        super(model, motor);
    }

    start():string {
        return `starting car, model: ${this.model} motor is ${this.motor}`;
    }

}

let car = new Opel("653", 3);