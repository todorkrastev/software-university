function foo(town) {
    let result = Object.entries(town).map(entry => `${entry[0]} -> ${entry[1]}`);
    return result.join('\n');
}