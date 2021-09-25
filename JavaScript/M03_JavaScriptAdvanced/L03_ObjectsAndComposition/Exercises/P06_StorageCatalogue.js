function storageCatalogue(arr) {
    let catalogue = {};
    arr.forEach(line => {
        let [productName, productPrice] = line.split(' : ');
        productPrice = Number(productPrice);
        let initialLetter = productName[0];

        if (!catalogue[initialLetter]) {
            catalogue[initialLetter] = {};
        }
        catalogue[initialLetter][productName] = productPrice;
    });
    let initLetSorted = Object.keys(catalogue).sort((a, b) => a.localeCompare(b));

    for (const key of initLetSorted) {
        let products = Object.entries(catalogue[key]).sort((a, b) => a[0].localeCompare(b[0]));
        console.log(key);
        products.forEach(product => {
            console.log(`  ${product[0]}: ${product[1]}`)
        });
    }
    
 /*   const result = arr.sort().reduce((a, v) => {
        a[v[0]] = a[v[0]] || []
        a[v[0]].push(v)
        return a
    }, {})
    Object.entries(result).forEach(([letter, items]) =>
        console.log(`${letter}
  ${items.map(y => y.split(" : ").join(": ")).join("\n  ")}`)
    ) */
}
