function printSmallestNumbers(arrStr) {
    const arrToNum = arrStr
        .map((i) => Number(i))
        .sort((a, b) => a - b);
    const arrToPrint = [arrToNum[0], arrToNum[1]];
    return arrToPrint;
}
