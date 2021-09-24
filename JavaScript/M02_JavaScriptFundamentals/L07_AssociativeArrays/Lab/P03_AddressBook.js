function addressBook(arr) {
    let addresses = {};

    for (let i = 0; i < arr.length; i++) {
        let splitInput = arr[i].split(':');
        let name = splitInput.shift();
        let address = splitInput.shift();

        addresses[name] = address;
    }

    return (Object.entries(addresses)
        .map(entry => `${entry[0]} -> ${entry[1]}`)
        .sort()
        .join('\n'));
}
