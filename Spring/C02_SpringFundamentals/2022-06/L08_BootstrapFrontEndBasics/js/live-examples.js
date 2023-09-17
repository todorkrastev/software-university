/*
    All of these examples were used during the live lecture and left for future reference
    You can copy and run these in your browser's developer tools' console
*/

/*
    Example: JS dynamic types
*/
// var example;
// example = null;
// example = 'Simeon Petrov';
// example = 13;
// example = 13.45;
// example = false;
// console.log(example)
// console.log(typeof example)

// const name = "George";  
// name = "Maria";

/*
    Example: Operators
*/
// console.log(1 == '1');
// console.log(1 === '1');
// console.log(3 != '3');
// console.log(3 !== '3');
// console.log(5 < 5.5);
// console.log(5 <= 4);
// console.log(2 > 1.5);
// console.log(2 >= 2);
// console.log(false ? 4 : 10);

/*
    Example: Functions and declaring types
*/
// function someFunction() {
//     console.log('Hi from our new function')
// }
// const someFunction = function () {
//     console.log('Hi from our new function')
// }
// const someFunction = (arg) => arg ? true : false;

/*
    Example: JS Truthy and Falsy values
*/
// console.log(someFunction(true));
// console.log(someFunction(false));
// console.log(someFunction(2));
// console.log(someFunction(0));
// console.log(someFunction(-1));
// console.log(someFunction(''));
// console.log(someFunction('false'));
// console.log(someFunction(null));
// console.log(someFunction(undefined));
// console.log(someFunction({}));
// console.log(someFunction([]));
// console.log(someFunction(NaN));
// console.log(someFunction(this));


/*
    Example: IIFE
*/
// IIFE - An IIFE (Immediately Invoked Function Expression) 
// is a JavaScript function that runs as soon as it is defined. 
// The name IIFE is promoted by Ben Alman in his blog. 
// (function () {
//     statements
// })();

/*
    Example: Function Parameters & default values
*/
// function foo(a, b, c = 'Simo') {
//     console.log(a);
//     console.log(b);
//     console.log(c);
// }

// foo(1, 2, 3, 4, 5, 6)

/*
    Example: JS Objects
*/

// let person = {
//     firstName: 'Simeon',
//     lastName: 'Petrov',
//     company: 'Blubito',
//     books: {
//         titles: ' .... ',
//         order: 123123
//     },
//     readBook() {
//         console.log("I'm reading")
//     }
// };

// let varExample = []

// console.log(person)
// console.log(person.books)


/*
    Example: Objects and properties
*/
// const objExample = {
//     a: 1,
//     b: 2,
//     c: {
//         name: 'Simo',
//         company: 'Blubito'
//     },
//     func(){
//         console.log('FUNCTION')
//     }
// };
// const secondObj = objExample;
// objExample.c = 'Hi';
// console.log(objExample)
// console.log(secondObj)

/*
    Example: Cloning objects
*/
// Shallow clone with spread
// const objClone = { ...objExample };
// objClone.d = true;
// objClone.c.experience = 5
// console.log(objExample)
// console.log(objClone)

// Clone with JSON
// const objClone = JSON.parse(JSON.stringify(objExample));
// objClone.d = true;
// objClone.c.experience = 5
// console.log(objExample)
// console.log(objClone)

/*
    Example: Object keys
*/
// const keys = Object.keys(objExample)
// console.log(keys)
// console.log(objExample.hasOwnProperty('d'))
// Object.prototype.hasOwnProperty.call(objExample, 1)

/*
    Example: Object new property syntaxes
*/
// objExample.d = 'new prop';
// const dynamicName = 'simo';
// objExample[1] = 'new custom prop'
// console.log(objExample)