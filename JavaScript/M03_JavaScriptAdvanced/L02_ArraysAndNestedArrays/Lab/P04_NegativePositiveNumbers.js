function orderNumbers(inputArr) {
    const arr = [];
    for (let index = 0; index < inputArr.length; index++) {
        let currNum = inputArr[index];
        if (currNum < 0) {
            arr.unshift(currNum);
        } else {
            arr.push(currNum);
        }
    }
    return arr.join('\r\n');

    /* return inputArr.reduce((a, v) => {
         v < 0 ? a.unshift(v) : a.push(v)
         return a
     }, []) */
}
