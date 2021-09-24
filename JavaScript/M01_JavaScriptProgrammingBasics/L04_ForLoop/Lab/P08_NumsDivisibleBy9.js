function sumOfNums(input) {
    let n1 = parseInt(input[0]);
    let n2 = parseInt(input[1]);
    let numsArr = [];

    let sum = 0;
    for (let i = n1; i <= n2; i++) {
        if (i % 9 == 0) { sum += i; numsArr.push(i) }
    }

    console.log(`The sum: ${sum}` + '\n'
        + `${numsArr.join('\n')}`);
}
