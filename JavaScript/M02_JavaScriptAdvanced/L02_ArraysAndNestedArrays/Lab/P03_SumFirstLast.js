function printSumFirstLast(inputArr) {
    let firstElement = Number([...inputArr].shift());
    let lastElement = Number([...inputArr].pop());
    let sum = firstElement + lastElement;
    return sum;
}
