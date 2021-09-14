function printSumOfDiagonals(array2d) {
    let rowsLen = array2d.length;
    let colsLen = array2d[0].length;
    let output = [printSumOfMainDiagonal(rowsLen, colsLen), printSumOfSecondaryDiagonal(rowsLen, colsLen)];
    return output.join(' ');

    function printSumOfMainDiagonal(rowsLen, colsLen) {
        let row = 0;
        let col = 0;
        let result = 0;
        while (row < rowsLen && col < colsLen) {
            result += array2d[row][col];
            row++;
            col++;
        }
        return result;
    }

    function printSumOfSecondaryDiagonal(rowsLen, colsLen) {
        let row = rowsLen - 1;
        let col = 0;
        let result = 0;
        while (0 <= row && col < colsLen) {
            result += array2d[row][col];
            row--;
            col++
        }
        return result;
    }
}
