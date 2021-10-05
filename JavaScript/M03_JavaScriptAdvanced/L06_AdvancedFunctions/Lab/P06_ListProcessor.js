function solve(input) {
    let arr = [];

    let obj = {
        add: (str) => arr.push(str),
        remove: (str) => arr = arr.filter(x => x !== str),
        print: () => console.log(arr.join(",")),
    };

    input.forEach(line => {
        const [command, str] = line.split(" ");

        obj[command](str);
    });
}
