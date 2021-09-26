function printRectangle(input) {
    let result = '';
    for (let i = 0; i < input; i++) {
        for (let j = 0; j < input; j++) {
            result += '* ';
        }
        console.log(result);
        result = '';
    }

 /*   const row = "* ".repeat(n).trim()
    for (let i = 0; i < n; i++) {
        console.log(row)
    } */
}
