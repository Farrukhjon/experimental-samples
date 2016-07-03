// Using Function Type via interface.
interface IFormatter {
    (data:string):string;
}

let upperCase:IFormatter;
let lowerCase:IFormatter;

upperCase = (data:string)=> data.toUpperCase();
lowerCase = (data:string)=> data.toLowerCase();

console.log(upperCase("hello world!"));
console.log(lowerCase("HELLO WORLD!"));
