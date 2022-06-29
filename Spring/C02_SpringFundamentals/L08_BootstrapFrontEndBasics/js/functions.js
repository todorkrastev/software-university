foo('foo'); //Foo is not a function and will throw and error
var foo = function (msg) { console.log(msg); return 5; }
console.log(foo('foo after'))


// baz('baz');
// function baz(msg) { console.log(msg); return 5; };
// console.log(baz('baz after'));