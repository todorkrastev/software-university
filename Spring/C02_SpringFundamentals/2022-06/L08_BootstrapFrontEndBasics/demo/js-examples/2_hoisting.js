//===================
//   variables
//===================
let a;
a = 5
console.log(a)


//===================
//   functions
//===================
named()
function named() {
    console.log("Named function called!")
}

//===================
//   anonymous-functions
//===================
//console.log(anon)
anon()
let anon = function() {
    console.log("Anon function assigned to let variable called!")
}

console.log(anon2)

var anon2 = function() {
    console.log("Anon function assigned to var variable called!")
}
anon2()