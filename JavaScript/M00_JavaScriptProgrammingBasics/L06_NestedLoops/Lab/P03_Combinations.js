function combinations(input) {
    let n = parseInt(input[0]);

    let validCombinationsCount = 0, sum = 0;
    for (let x1 = 0; x1 <= n; x1++) {
        for (let x2 = 0; x2 <= n; x2++) {
            for (let x3 = 0; x3 <= n; x3++) {
                if (x1 + x2 + x3 == n) {
                    validCombinationsCount++;
                }
            }
        }
    }
    console.log(validCombinationsCount);
}
