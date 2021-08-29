function solve(string, char, result) {
    let res = string.replace('_', char);
    let output = res === result ? 'Matched' : 'Not Matched';
    console.log(output);
}
