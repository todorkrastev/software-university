function printLastKNumbersSequence(n, k) {
    const printArr = [];
    printArr[0] = 1;

    let num = Number(n);
    let sequence = Number(k);

    for (let index = 1; index < num; index++) {
        let currNum = 0;
        let i = index;
        if (index < sequence) {
            for (let j = i; j > 0; j--) {
                i--;
                currNum += printArr[i];
            }
        } else {
            for (let j = sequence; j > 0; j--) {
                i--;
                currNum += printArr[i];
            }
        }
        printArr[index] = currNum;
    }
    return printArr;

  /*  const arr = [1]
    for (let i = 1; i < n; i++) {
        arr.push(arr.slice(-k).reduce((a, v) => a + v, 0))
    }
    return arr */
}
