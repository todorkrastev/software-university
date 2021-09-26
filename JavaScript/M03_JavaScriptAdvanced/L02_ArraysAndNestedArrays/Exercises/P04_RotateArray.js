function rotateArray(arrayStr, nth) {
    
    // nth % arrayStr.length improves the performance significantly

    for (let index = 0; index < nth % arrayStr.length; index++) {
        rotateRight(arrayStr);
    }

    return arrayStr.join(' ');

    function rotateRight(arr) {
        let last = arr.pop();
        arr.unshift(last);
        return arr;
    }

   /* for (let i = 0; i < n; i++) {
        arr.unshift(arr.pop())
    }

    return arr.join(" ") */
}
