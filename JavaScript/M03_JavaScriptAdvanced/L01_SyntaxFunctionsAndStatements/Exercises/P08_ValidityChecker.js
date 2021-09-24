function solve(first, second, third, fourth) {

    let x1 = Number(first);
    let y1 = Number(second);
    let x2 = Number(third);
    let y2 = Number(fourth);

    result(x1, y1, 0, 0);
    result(x2, y2, 0, 0);
    result(x1, y1, x2, y2);

    function result(x1, y1, x2, y2) {
        const distance = Math.sqrt((x1 - x2) ** 2 + (y1 - y2) ** 2);
        const validString = Number.isInteger(distance) ? 'valid' : 'invalid';
        console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is ${validString}`);

        return Math.sqrt((x1 - x2) ** 2 + (y1 - y2) ** 2);
    }
}
