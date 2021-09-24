function storage(input) {
    let itemsMap = new Map();

    for (let i = 0; i < input.length; i++) {
        let splitInput = input[i].split(' ');
        let item = splitInput.shift();
        let quantity = Number(splitInput.shift());

        if (!itemsMap.has(item)) {
            itemsMap.set(item, +quantity);
        } else {
            let currQuantity = itemsMap.get(item);
            itemsMap.set(item, currQuantity += quantity);
        }
    }

    for (let [item, quantity] of itemsMap) {
        console.log(`${item} -> ${quantity}`);
    }
}
