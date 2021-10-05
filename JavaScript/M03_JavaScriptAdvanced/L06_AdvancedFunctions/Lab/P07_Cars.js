function solve(input) {
    const data = {};

    const parser = {
        create: (carName, inherits, parentName) =>
            (data[carName] = inherits ? Object.create(data[parentName]) : {}),
        set: (carName, k, v) => (data[carName][k] = v),
        print: carName => {
            const entry = [];
            for (const key in data[carName]) {
                entry.push(`${key}:${data[carName][key]}`);
            }
            console.log(entry.join(","));
        },
    };

    input.forEach(line => {
        const [c, n, k, v] = line.split(" ");

        parser[c](n, k, v);
    });
}
