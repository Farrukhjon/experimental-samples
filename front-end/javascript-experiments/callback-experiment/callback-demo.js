function print() {
    console.log("Images is printed")
}

function downloadImageAndPrint(s, print) {
    console.log("Downloading...");
    setTimeout(print, 700);
}
downloadImageAndPrint('images', print);

console.log("App finished?");

