class Animal implements IAnimal {

    private _name = '[Some Animal]'; // type inference is working for name property depending from value '[Some Animal]'

    constructor(name:string) {
        this._name = name;
    }

    get name():string {
        return this._name;
    }

    set name(value:string) {
        this._name = value;
    }

    sayName():void {
        console.log(`My name is ${this.name}`)
    }

}