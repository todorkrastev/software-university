function cleverLily(input) {
    let age = parseInt(input[0]);
    let laundryPrice = Number(input[1]);
    let toyPrice = parseInt(input[2]);

    let gain = 10, sum = 0;
    for (let i = 1; i <= age; i++) {
        if (i % 2 == 0) {
            sum += gain;
            gain += 10;
            sum -= 1;
        } else {
            sum += toyPrice;
        }
    }

    if (sum >= laundryPrice) {
        let moneyLeft = sum - laundryPrice;
        console.log(`Yes! ${moneyLeft.toFixed(2)}`);
    } else {
        let moneyNeeded = laundryPrice - sum;
        console.log(`No! ${moneyNeeded.toFixed(2)}`);
    }
}
