function solve() {
    let result = [];
    let count = {};

    [...arguments].forEach(argument => {
        let type = typeof argument;

        result.push({ type, value: argument });

        if (!count[type]) {
            count[type] = 0;
        }

        count[type]++;
    });
    result.forEach(r => console.log(`${r.type}: ${r.value}`));

    let sort = Object.entries(count).sort((a, b) => b[1] - a[1]);

    sort.forEach(e => {
        console.log(`${e[0]} = ${e[1]}`);
    });
}



// modification


// function solve(...args) {
//     const count = {};
//     const result = args.map(a => {
//         count[typeof a] = (count[typeof a] || 0) + 1;
//         return `${typeof a}: ${a}`;
//     })

//     result.forEach(r => console.log(r));
//     Object.entries(count).sort((a, b) => b[1] - a[1]).map(([type, counts]) =>
//         console.log(`${type} = ${counts}`)
//     );
// }
