function lowestPricesInCities(arr) {
    let printCityPrices = {};
    arr.forEach(line => {
        let [townName, productName, productPrice] = line.split(' | ');
        productPrice = Number(productPrice);

        if (!printCityPrices[productName]) {
            printCityPrices[productName] = {};
        }
        printCityPrices[productName][townName] = productPrice;
    });

    for (const product in printCityPrices) {
        const sorted = Object.entries(printCityPrices[product]).sort((a, b) => a[1] - b[1]);
        console.log(`${product} -> ${sorted[0][1]} (${sorted[0][0]})`);
    }

 /*   const data = arr
    .map(x => x.split(" | "))
    .reduce((a, v) => {
        const [town, product, price] = v.map(x => (isNaN(x) ? x : Number(x)))
        a[product] = a[product] || { price, town }
        if (a[product].price > price || a[product].town === town) {
            a[product] = { price, town }
        }
        return a
    }, {})

return `${Object.entries(data)
    .map(([name, product]) => `${name} -> ${product.price} (${product.town})`)
    .join("\n")}` */
}
