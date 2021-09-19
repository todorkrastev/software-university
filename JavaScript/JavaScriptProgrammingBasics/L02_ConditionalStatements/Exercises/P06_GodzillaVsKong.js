function godzillaVsKong(a, b, c) {
    let budgetForMovie = Number(a);
    let countOfExtras = Number(b);
    let priceForClothingOneExtra = Number(c);

    let priceForDecor = budgetForMovie * 0.10;
    let priceForClothing = countOfExtras * priceForClothingOneExtra;

    if (countOfExtras > 150) {
        priceForClothing -= priceForClothing * 0.10;
    }

    let total = priceForDecor + priceForClothing;

    if (total <= budgetForMovie) {
        console.log(`Action!`);
        console.log(`Wingard starts filming with ${(budgetForMovie - total).toFixed(2)} leva left.`);
    } else {
        console.log(`Not enough money!`);
        console.log(`Wingard needs ${(total - budgetForMovie).toFixed(2)} leva more.`);
    }
}
