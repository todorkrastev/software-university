function mathPower(number, power) {
    let total = number;
    for (let i = 1; i < power; i++) {
        total *= number;
    }
    console.log(total);
}
