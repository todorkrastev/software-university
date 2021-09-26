function printSumFirstLast(inputArr) {
    let firstElement = Number([...inputArr].shift());
    let lastElement = Number([...inputArr].pop());
    let sum = firstElement + lastElement;
    return sum;

   /* inputArr = inputArr.map(Number)
    return inputArr[0] + inputArr[inputArr.length - 1] */
}
