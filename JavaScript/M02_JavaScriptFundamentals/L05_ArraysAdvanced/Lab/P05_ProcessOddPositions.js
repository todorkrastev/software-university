function foo(arr) {
    let numsAtOddPositions = arr.filter((x, i) => i % 2);
    let multipliedNums = numsAtOddPositions.map(num => num * 2);

    return multipliedNums.reverse().join(' ');
}
