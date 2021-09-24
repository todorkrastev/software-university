function foo(n, k) {
    let newArr = [1];
    let sequenceLength = n - 1;

    for (let i = 0; i < sequenceLength; i++) {
        if (i == 0) {
            newArr.push(newArr[0]);
        } else {
            let numsSum = newArr.slice(-k).reduce((a, b) => a + b);
            newArr.push(numsSum);
        }
    }
    return newArr.join(' ');
}
