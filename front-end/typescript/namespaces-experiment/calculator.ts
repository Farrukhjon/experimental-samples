namespace Calculator {

    // nested namespace
    export namespace BasicCalculator {
        export function add(a:number, b:number):number {
            return a + b;
        }
    }

    // nested namespace
    export namespace AdvancedCalculator {
        export function add(a:number, b:number, c:number):number {
            return a + b + c;
        }
    }

    // private function within this namespace
    function privateFunction() {
        console.log("Invoking the private function which is within in this (Calculator) namespace...")
    }

    privateFunction();

}
