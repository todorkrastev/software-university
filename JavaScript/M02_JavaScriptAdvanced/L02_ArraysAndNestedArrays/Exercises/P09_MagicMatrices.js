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
}
console.log(isMagicMatrix([[4],
    [5],
    [6]]
   ));