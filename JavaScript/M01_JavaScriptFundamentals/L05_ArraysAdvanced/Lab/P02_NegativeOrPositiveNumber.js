function foo(arr) {
    let newArr = [];
    let addToNewArr = arr.map(num => num < 0 ? newArr.unshift(num) : newArr.push(num))
    return newArr.join('\n')
}
