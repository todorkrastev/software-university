// Closures Example 1 - var vs let
console.log("What's this var at the start?", varExample)
var varExample = 'Lion'
console.log("What's this var at the end?", varExample)


console.log("What's this var at the start?", letExample)
let letExample = 'Fish'
console.log("What's this var at the end?", letExample)


// Closures - issues with var
console.log(i)
for (var i = 0; i < 3; i++) {
    const logit = function () {
        debugger
        console.log(i)
    }
    setTimeout(logit, 100)
}

// Closures - encapsulate code
// console.log(k)
function encapsulateIt() {
    console.log(k)
    for (var k = 0; k < 3; k++) {
        const logit = function () {
            console.log(k)
        }
        setTimeout(logit, 100)
    }
}
encapsulateIt();


// Closures with function declaration and expression