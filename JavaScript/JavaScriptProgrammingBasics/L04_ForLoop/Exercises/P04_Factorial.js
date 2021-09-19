function factorial(input) {
    let num = parseInt(input[0]);

    let sum = 1;
    for (let i = 1; i <= num; i++) {
        sum += sum * (num - i);
    }
    console.log(sum);
}
