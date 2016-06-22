import { sayHello } from "./greet";

function hello(compiler:string) {
   console.log(`Hello from ${compiler}`);
}

hello("TypeScript!");

console.log(sayHello("TypeScript"));

