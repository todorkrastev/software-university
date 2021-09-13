function printBiggerHalf(strArr) {
    const arrToNum = strArr
        .map((i) => Number(i))
        .sort((a, b) => a - b);
    const half = Math.ceil(arrToNum.length / 2);
    const secondHalf = arrToNum.splice(-half);
    return secondHalf;
}
