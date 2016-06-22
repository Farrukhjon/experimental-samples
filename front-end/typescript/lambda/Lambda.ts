class LambdaDemo {

    private list:number[];

    constructor() {
        this.list = [0, 1, 2, 3, 4, 5];
    }

    public print() {
        this.list.forEach(item => {
            console.log(item);
        });
    }

    public get() {
        return this.list
    }
}

var lam = new LambdaDemo();