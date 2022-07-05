let person = {
    name: "John",
    age: 24,
    address: "Sample Street N13"
}

console.log(JSON.stringify("asd"))

//===================
//   references
//===================
// let person2 = person
// person2.name = "Peter"

// console.log(person)

//===================
//   keys and values
//===================
//console.log(Object.keys(person))
//console.log(Object.values(person))

//===================
//   for-in (enumerable objects)
//===================
for(const key in person) {
    console.log(key)
}

//===================
//   for-of (iterable objects)
//===================
let arr = [1, 2, 3, 4, 5]
for(const val of Object.values(person)) {
    console.log(val)
}