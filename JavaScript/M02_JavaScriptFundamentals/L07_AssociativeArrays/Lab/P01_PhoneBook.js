function foo(input) {
    let phones = {};
    for (let i = 0; i < input.length; i++) {
        let splitInput = input[i].split(' ');
        let name = splitInput.shift();
        let number = splitInput.shift();
        phones[name] = number;
    }

    return Object.entries(phones)
        .map(entry => {
            let name = entry[0];
            let phone = entry[1];
            return `${name} -> ${phone}`
        })
        .join('\n');
}
