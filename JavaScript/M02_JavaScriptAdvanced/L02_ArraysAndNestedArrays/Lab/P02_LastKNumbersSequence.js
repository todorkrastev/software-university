function printLastKNumbersSequence(n, k) {
    let printArr = [];
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
}
