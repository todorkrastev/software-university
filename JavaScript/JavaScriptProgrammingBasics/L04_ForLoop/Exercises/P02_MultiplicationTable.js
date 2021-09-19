function multiplicationTable(input) {
    let n = parseInt(input[0]);

    for (i = 1; i <= 10; i++) {
        let sum = i * n
        console.log(`${i} * ${n} = ${sum}`);
    }
}
