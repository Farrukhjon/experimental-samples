import {Calc} from "./math";
import * as util from "./util";

let cal = new Calc();
let printer = new util.Printer();

for (let i = 0; i < 10; i++) {
    let result = cal.add(i, i + 1);
    console.log(printer.print(result));
}
