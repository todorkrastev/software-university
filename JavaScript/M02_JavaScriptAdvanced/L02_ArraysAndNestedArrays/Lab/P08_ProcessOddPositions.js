function printOddNumbers(strArr) {
    const arrToNum = strArr
        .map((e) => Number(e))
        .filter((a, e) => e % 2 == 1)
        .map((e) => e * 2)
        .reverse()
        .join(' ');

    return arrToNum;
}
