function histogram(input) {
    let count = parseInt(input[0]);

    let n1 = 0, n2 = 0, n3 = 0, n4 = 0, n5 = 0;
    for (let i = 1; i <= count; i++) {

        let n = parseInt(input[i]); // get input for each number

        // Increment if number falls within range
        if (n < 200) { n1++; }
        else if (n >= 200 && n < 400) { n2++; }
        else if (n >= 400 && n < 600) { n3++; }
        else if (n >= 600 && n < 800) { n4++; }
        else if (n >= 800) { n5++; }
    }

    // Save values to print
    let pct = {
        n1: ((n1 / count) * 100).toFixed(2) + `%`,
        n2: ((n2 / count) * 100).toFixed(2) + `%`,
        n3: ((n3 / count) * 100).toFixed(2) + `%`,
        n4: ((n4 / count) * 100).toFixed(2) + `%`,
        n5: ((n5 / count) * 100).toFixed(2) + `%`
    }

    // Print each value, separated by new line
    console.log(Object.values(pct).join('\n'));
}
