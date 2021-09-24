function neighborhoods(arr) {
    let neighborhoods = arr.shift().split(', ');
    let neighborhoodsMap = new Map();
    neighborhoods.forEach(neighborhood => neighborhoodsMap.set(neighborhood, []));

    for (let i = 0; i < arr.length; i++) {
        let splitArr = arr[i].split(' - ');
        let neighborhood = splitArr.shift();
        let person = splitArr.shift();

        if (neighborhoodsMap.has(neighborhood)) {
            neighborhoodsMap.set(neighborhood, neighborhoodsMap.get(neighborhood).concat(person));
        }
    }

    let sorted = Array.from(neighborhoodsMap.entries()).sort((a, b) => {
        return b[1].length - a[1].length;
    });

    sorted.map(entry => {
        let neighborhood = entry[0];
        let residents = entry[1];
        console.log(`${neighborhood}: ${residents.length}`)
        if (residents.length > 0) {
            console.log(`${residents.map(resident => `--${resident}`).join('\n')}`);
        }
    })
}
