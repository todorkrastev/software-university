function fishingBoat(input) {
    let groupBudget = parseInt(input[0]);
    let season = input[1];
    let fishermen = parseInt(input[2]);

    let rent = {
        Spring: 3000,
        Summer: 4200,
        Autumn: 4200,
        Winter: 2600
    }

    rent = rent[season];

    if (fishermen <= 6) {
        rent -= (10 / 100) * rent;
    } else if (fishermen > 6 && fishermen <= 11) {
        rent -= (15 / 100) * rent;
    } else if (fishermen > 11) {
        rent -= (25 / 100) * rent;
    }
    if (fishermen % 2 == 0 && season != "Autumn") {
        rent -= (5 / 100) * rent;
    }

    if (groupBudget >= rent) {
        let diff = groupBudget - rent;
        console.log(`Yes! You have ${diff.toFixed(2)} leva left.`);
    } else {
        let diff = Math.abs(rent - groupBudget);
        console.log(`Not enough money! You need ${diff.toFixed(2)} leva.`);
    }
}
