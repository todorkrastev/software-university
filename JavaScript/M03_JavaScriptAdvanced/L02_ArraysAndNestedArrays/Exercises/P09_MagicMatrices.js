function isMagicMatrix(matrix) {
    let sumRow = row => matrix[row].reduce((a, b) => a + b);
    let sumCol = col => matrix.map(row => row[col])
        .reduce((a, b) => a + b);

    if (matrix.length > 0) {
        let targetSum = sumRow(0);
        for (let row = 1; row < matrix.length; row++) {
            let rowSum = sumRow(row);
            if (rowSum !== targetSum) {
                return false;
            }
        }

        for (let col = 0; col < matrix[0].length; col++) {
            let colSum = sumCol(col);
            if (colSum !== targetSum) {
                return false;
            }
        }
    }
    return true;

    /* return [
         ...arr.map(x => x.reduce((a, v) => a + v, 0)),
         ...arr.reduce((a, v, i) => {
             a.push(arr.reduce((c, d) => c + d[i], 0))
             return a
         }, []),
     ].every((x, _, arr) => x === arr[0])return [
         ...arr.map(x => x.reduce((a, v) => a + v, 0)),
         ...arr.reduce((a, v, i) => {
             a.push(arr.reduce((c, d) => c + d[i], 0))
             return a
         }, []),
     ].every((x, _, arr) => x === arr[0]) */
}
