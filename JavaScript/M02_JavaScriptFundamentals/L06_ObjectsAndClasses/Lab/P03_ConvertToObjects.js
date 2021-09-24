function foo(stringJSON) {
    let person = JSON.parse(stringJSON);
    let result = Object.entries(person).map(i => `${i[0]}: ${i[1]}`);
    return result.join('\n');
}
