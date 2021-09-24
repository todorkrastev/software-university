function solve(num) {
    let output = "";
    for (let i = 1; i <= num; i++) {
        for (let j = 1; j <= i; j++) {
            output += i + " ";
        }
        console.log(output);
        output = "";
    }
}
