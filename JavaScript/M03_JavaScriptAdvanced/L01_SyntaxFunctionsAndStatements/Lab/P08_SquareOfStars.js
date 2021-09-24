function printRectangle(input) {
    let result = '';
    for (let i = 0; i < input; i++) {
        for (let j = 0; j < input; j++) {
            result += '* ';
        }
        console.log(result);
        result = '';
    }
}
