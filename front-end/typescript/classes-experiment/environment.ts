export class Environment {

    constructor(public id:number, public name:string) {
    }

    getProperties() {
        return `${this.id} : ${this.name}`;
    }
}

let serverEnv = new Environment(80, 'port');

console.log(serverEnv);