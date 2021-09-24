function foo(arr) {
    const first = Number(arr.shift());
    const last = Number(arr.pop())

    let arrayElsMoreThanOne = arr.length > 1;
    let sum = arrayElsMoreThanOne ? first + last : first + first;

    return sum;
}
