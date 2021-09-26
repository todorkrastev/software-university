function printBiggestElement(array2d) {
    let biggestElement = Number.NEGATIVE_INFINITY;

    for (let row = 0; row < array2d.length; row++) {
        for (let col = 0; col < array2d[row].length; col++) {
            let currElement = array2d[row][col];
            let isItString = Boolean(isNaN(currElement));
            if (isItString) {
                let index = currElement.charCodeAt(0);
                if (biggestElement < index) {
                    biggestElement = index;
                }
            } else {
                if (biggestElement < currElement) {
                    biggestElement = currElement;
                }
            }
        }
    }
    let typeOfElement = array2d.every(row => row.every(element => typeof element === 'number'));
    return typeOfElement === true ? biggestElement : String.fromCharCode(biggestElement);

  //  return array2d.reduce((a, v) => (a = Math.max(...v) > a ? Math.max(...v) : a), -Infinity)
}
