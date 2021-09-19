function toyShop(a, b, c, d, e, f) {
    let puzzle = 2.60
    let talkingDoll = 3
    let teddyBear = 4.10
    let minion = 8.20
    let truck = 2

    let priceTrip = Number(a);
    let numberPuzzles = Number(b);
    let numberTalkingDolls = Number(c);
    let numberTeddyBears = Number(d);
    let numberMinions = Number(e);
    let numberTrucks = Number(f);

    let amount = numberPuzzles * puzzle + numberTalkingDolls * talkingDoll + numberTeddyBears * teddyBear + numberMinions * minion + numberTrucks * truck;
    let numberToy = numberPuzzles + numberTalkingDolls + numberTeddyBears + numberMinions + numberTrucks;

    if (numberToy >= 50) {
        amount -= amount * 0.25;
    }

    let rent = amount * 0.10;
    let profit = amount - rent;


    if (profit >= priceTrip) {
        console.log((`Yes! ${(profit - priceTrip).toFixed(2)} lv left.`));
    } else {
        console.log(`Not enough money! ${(priceTrip - profit).toFixed(2)} lv needed.`);
    }
}
