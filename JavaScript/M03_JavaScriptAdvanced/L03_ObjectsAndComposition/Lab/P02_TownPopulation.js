function printTownPopulation(towns) {
    const townsInfo = {};

    for (const town of towns) {
        let townInfo = [];
        townInfo = town.split(' <-> ');
        let name = townInfo[0];
        let population = Number(townInfo[1]);

        if (townsInfo.hasOwnProperty(name)) {
            townsInfo[name] += population;
        } else {
            townsInfo[name] = population;
        }
    }
    for (const town in townsInfo) {
        console.log(`${town} : ${townsInfo[town]}`);
    }

    /* const parsedData = arr.reduce((a, b) => {
         const [name, population] = b.split(" <-> ")
         a[name] = (a[name] || 0) + Number(population)
         return a
     }, {})
 
     return Object.entries(parsedData)
         .map(x => `${x[0]} : ${x[1]}`)
         .join("\n") */
}
