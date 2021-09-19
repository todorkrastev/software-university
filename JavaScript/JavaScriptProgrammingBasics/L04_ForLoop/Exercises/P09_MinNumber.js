function minNumber(input) {
    let n = Number(input[0]);

    let num = 0, numArr = [];
    for (let i = 1; i <= n; i++) {
        num = input[i];
        numArr.push(num);
    }
    console.log(Math.min(...numArr));
}
