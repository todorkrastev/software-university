function f() {
    console.log("Hello!")
}
f()

function argFunction(arg1, arg2) {
    console.log(arg1, arg2)
}
function argFunction(arg1, arg2, arg3) {
    console.log(arg1, arg2, arg3)
}
argFunction("Hello", "World")
argFunction("Hi")
argFunction("Hello", "World", "These", "Will", "Be", "Ignored")

function nArgFunction(arg1, arg2, ... args) {
    console.log(arguments)
}
nArgFunction("H", "E", "L", "L", "O")

//===================
//   declaring functions
//===================
let anon = function() {
    console.log("Anonymous!")
}
anon()

let arrow = () => {
    console.log("Arrow!")
}
arrow()

//===================
//   higher order functions
//===================

let sum = (a, b) => { return a + b }
let product = (a, b) => { return a * b }
let max = (a, b) => { return a > b ? a : b }

function aggregate(f, defaultVal, ...args) {
    if (args.length == 0) {
        return defaultVal
    }

    let sum = args[0]
    for(let i = 1; i < args.length; i++) {
        sum = f(sum, args[i])
    }

    return sum
}

console.log(aggregate(sum, 0, 1,2,3,4))
console.log(aggregate(product, 1, 1,2,3,4))
console.log(aggregate(max, undefined, 1,2,3,4))

//===================
//   built-in higher order functions
//===================
let a = [1, 2, 3, 4, 5]
    .filter((num) => num % 2 == 0)
    // .map((evenNum) => evenNum * evenNum)
    // .reduce((a, b) => a + b)

console.log(a)