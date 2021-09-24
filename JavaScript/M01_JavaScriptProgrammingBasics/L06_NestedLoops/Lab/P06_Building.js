function building(input) {
    let index = 0;
    const floors = parseInt(input[index++]);
    const roomsPerFloor = parseInt(input[index++]);

    for (let f = floors; f >= 1; f--) {
        let symbol = ``, line = ``;
        if (f == floors) {
            symbol = `L`
        }
        else if (f % 2 != 0) {
            symbol = `A`
        }
        else if (f % 2 == 0) {
            symbol = `O`
        }
        for (let r = 0; r < roomsPerFloor; r++) {
            line += ` ${symbol}${f}${r}`;
        }
        console.log(line.trim());
    }
}
