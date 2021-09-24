function sumOfTwoNumbers(input) {
    let index = 0;
    let n1 = parseInt(input[index++]);
    let n2 = parseInt(input[index++]);
    let magicNumber = parseInt(input[index++]);

    let count = 0, found = false;
    for (let x = n1; x <= n2; x++) {
        for (let y = n1; y <= n2; y++) {
            count++;
            if (x + y == magicNumber) {
                console.log(`Combination N:${count} (${x} + ${y} = ${x + y})`);
                found = true;
                break;
            }
        }
        if (found) { break; }
    }
    if (!found) {
        console.log(`${count} combinations - neither equals ${magicNumber}`);
    }
}
