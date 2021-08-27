function solve(input) {
    let sum = 0;
    let count = 0;
    for (let i = 1; i <= 100; i++) {
        if (i % 2 === 1 && count < input) {
            console.log(i);
            sum += i;
            count++;
        }
    }
    console.log("Sum: " + sum)
}
