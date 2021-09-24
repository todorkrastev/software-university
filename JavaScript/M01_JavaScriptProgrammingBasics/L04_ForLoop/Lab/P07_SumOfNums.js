function sumOfNums(input) {
    let n = input[0];

    let sum = 0;
    for (let i = 0; i < n.length; i++) {
        let add = parseInt(n[i]);
        sum += add;
    }
    console.log(`The sum of the digits is:${sum}`);
}
