function diagonalAttack(matrix) {
    for (let i = 0; i < matrix.length; i++) {
        matrix[i] = matrix[i].split(' ').map(Number)
    }

    let firstDiagonalSum = 0, secondDiagonalSum = 0;

    let v = matrix.length - 1;
    for (let i = 0; i < matrix.length; i++) {
        firstDiagonalSum += matrix[i][i];
        secondDiagonalSum += matrix[i][v];
        v--;
    }

    if (firstDiagonalSum == secondDiagonalSum) {
        v = matrix.length - 1;
        for (let i = 0; i < matrix.length; i++) {
            matrix[i].map((num, index) => {
                if (index !== i && index !== v) { matrix[i][index] = firstDiagonalSum }
            })
            v--;
        }
    }

    matrix.forEach(line => console.log(line.join(' ')));
}
