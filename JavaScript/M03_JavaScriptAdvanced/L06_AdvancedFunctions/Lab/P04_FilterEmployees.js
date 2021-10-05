function solve(data, criteria) {
    let [prefix, value] = criteria.split('-');
    let counter = 0;

    JSON.parse(data).forEach(person => selectByCriteria.call(person));

    function selectByCriteria() {
        if (this[prefix] === value || criteria === 'all') {
            return console.log(`${counter++}. ${this.first_name} ${this.last_name} - ${this.email}`);
        }
    }


    
     // second option


    // const parsed = JSON.parse(data);
    // const [crit, specificCrit] = criteria.split("-");

    // return parsed
    //     .filter(x => x[crit] === specificCrit || x[crit] === 'all')
    //     .map((x, i) => `${i}. ${x.first_name} ${x.last_name} - ${x.email}`)
    //     .join("\n");
}
