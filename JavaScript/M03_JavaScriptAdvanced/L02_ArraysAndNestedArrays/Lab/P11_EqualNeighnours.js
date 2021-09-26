function findPairs(array2d) {
    let rowsLen = array2d.length;
    let colsLen = array2d[0].length;
    let counter = 0;

    for (let rows = 0; rows < array2d.length; rows++) {
        for (let cols = 0; cols < array2d[rows].length; cols++) {
            let currElement = array2d[rows][cols];
            //     checkUp(rows, cols, currElement, array2d);
            checkDown(rows, cols, currElement, array2d);
            checkRight(rows, cols, currElement, array2d);
            //        checkLeft(rows, cols, currElement, array2d);
        }
    }

    return counter;

    function checkPos(row, col) {
        if (0 <= row && row < rowsLen && 0 <= col && col < colsLen) {
            return true;
        }
        return false;
    }

    /*  function checkUp(row, col, currElement, array2d) {
          row--;
          if (checkPos(row, col) === true) {
              let upperElement = array2d[row][col];
              if (currElement === upperElement) {
                  counter++;
              }
          }
      } */

    function checkDown(row, col, currElement, array2d) {
        row++;
        if (checkPos(row, col) === true) {
            let lowerElement = array2d[row][col];
            if (currElement === lowerElement) {
                counter++;
            }
        }
    }

    function checkRight(row, col, currElement, array2d) {
        col++;
        if (checkPos(row, col) === true) {
            let rightElement = array2d[row][col];
            if (currElement === rightElement) {
                counter++;
            }
        }
    }

    /*  function checkLeft(row, col, currElement, array2d) {
          col--;
          if (checkPos(row, col) === true) {
              let leftElement = array2d[row][col];
              if (currElement === leftElement) {
                  counter++;
              }
          }
      } */
}

//second option

/* function findPairsII(arr) {
    let count = 0
    arr.forEach(x =>
        x.reduce((a, v) => {
            if (a === v) {
                count += 1
            }
            return v
        })
    )

    for (let i = 0; i < arr.length - 1; i++) {
        arr[i].forEach((_, j) => {
            if (arr[i][j] === arr[i + 1][j]) {
                count += 1
            }
        })
    }
    return count
} */