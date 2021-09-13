function printEvenNum(inputArr) {
    const evenNumArr = [];
    for (let index = 0; index < inputArr.length; index += 2) {
        let currElement = inputArr[index];
        evenNumArr[index] = currElement;
    }
    return evenNumArr
        .filter(e => e != null)
        .join(' ');
}
