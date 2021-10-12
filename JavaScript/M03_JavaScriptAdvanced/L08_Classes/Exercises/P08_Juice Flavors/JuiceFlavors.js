function solve(juicesArr) {
    let juicesAmount = new Map();
    let juicesBottles = new Map();

    for (let index = 0; index < juicesArr.length; index++) {
        let [juiceName, amount] = juicesArr[index].split(' => ');
        amount = Number(amount);

        if (!juicesAmount.has(juiceName)) {
            juicesAmount.set(juiceName, 0);
        }

        let totalAmount = juicesAmount.get(juiceName) + amount;

        if (totalAmount >= 1000) {
            if (!juicesBottles.has(juiceName)) {
                juicesBottles.set(juiceName, 0);
            }
            let newBottles = Math.trunc(totalAmount / 1000);
            let totalBottles = juicesBottles.get(juiceName) + newBottles;
            juicesBottles.set(juiceName, totalBottles);
        }


        juicesAmount.set(juiceName, totalAmount % 1000);
    }

    juicesBottles.forEach((value, key) => console.log(`${key} => ${value}`));

    // console.log([...juicesBottles]
    //     .map(([key, value]) => `${key} => ${value}`)
    //     .join('\n'));


    // for (const [key, value] of juicesBottles.entries()) {
    //     console.log(`${key} => ${value}`);
    // }



    // second option


    // const juices = {};
    // const bottles = {};

    // const addBottles = (n, q) => {
    //     const btlToAdd = (q - (q % 1000)) / 1000;

    //     if (btlToAdd > 0) {
    //         bottles[n] = (bottles[n] || 0) + btlToAdd;
    //         return q % 1000;
    //     }

    //     return q;
    // };

    // arr.forEach(x => {
    //     const [name, quantity] = x.split(' => ');
    //     juices[name] = juices[name] || 0;

    //     juices[name] = addBottles(name, juices[name] + Number(quantity));

    // })

    // return Object.entries(bottles)
    //     .map(([name, quantity]) => `${name} => ${quantity}`)
    //     .join('\n');

}
