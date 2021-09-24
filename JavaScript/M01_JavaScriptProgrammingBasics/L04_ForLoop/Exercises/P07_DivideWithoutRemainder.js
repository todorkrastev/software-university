function divideWithoutRemainder(input) {
    let count = parseInt(input[0]);

    let n1 = 0, n2 = 0, n3 = 0;
    for (let i = 1; i <= count; i++) {

        let n = parseInt(input[i]); // get input for each number

        // Increment if number falls within range
        if (n % 2 == 0) { n1++; }
        if (n % 3 == 0) { n2++; }
        if (n % 4 == 0) { n3++; }
    }

    // Save values to print
    let pct = {
        n1: ((n1 / count) * 100).toFixed(2) + `%`,
        n2: ((n2 / count) * 100).toFixed(2) + `%`,
        n3: ((n3 / count) * 100).toFixed(2) + `%`
    }

    // Print each value, separated by new line
    console.log(Object.values(pct).join('\n'));
}
