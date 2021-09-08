function getSumOfNums(x, y) {
    let firstNum = Number(x);
    let secondNum = Number(y);

    let sumOfNums = 0;
    for (let index = firstNum; index <= secondNum; index++) {
        sumOfNums += index;
    }
    console.log(sumOfNums);
}
