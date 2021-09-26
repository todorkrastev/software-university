function sortingNumbers(arrayNum) {
    arrayNum = arrayNum.map(Number);
    let output = [];

    while (!isArrayEmpty(arrayNum)) {
        let nextSmallestNum = removeSmallest(arrayNum);
        addElementToTheEnd(output, nextSmallestNum);
        arrayNum = filterArray(arrayNum, nextSmallestNum);
        if (!isArrayEmpty(arrayNum)) {
            let nextBiggestNum = removeBiggest(arrayNum);
            addElementToTheEnd(output, nextBiggestNum);
            arrayNum = filterArray(arrayNum, nextBiggestNum);
        }
    }

    function removeSmallest(arr) {
        let minNum = Math.min(...arr);
        return minNum;
    }

    function removeBiggest(arr) {
        let maxNum = Math.max(...arr);
        return maxNum;
    }

    function filterArray(arr, nextNum) {
        let removeNum = arr.find(n => n === nextNum);
        let indexToRemove = arr.indexOf(removeNum);
        arr.splice(indexToRemove, 1);
        return arr;
    }

    function addElementToTheEnd(arr, nextNum) {
        arr.push(nextNum);
    }

    function isArrayEmpty(arr) {
        return arr.length === 0;
    }

    return output;

    /* let i = arr.length - 1
     return arr
         .sort((a, b) => a - b)
         .reduce((a, v, _, tArr) => {
             a.push(v)
             a.push(tArr[i--])
             return a
         }, [])
         .slice(0, arr.length) */
}
