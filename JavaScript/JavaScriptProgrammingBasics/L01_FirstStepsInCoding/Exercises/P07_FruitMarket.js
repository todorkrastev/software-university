function fruitMarket(a, b, c, d, e) {
    let priceStrawberries = Number(a);
    let amountBananas = Number(b);
    let amountOranges = Number(c);
    let amountRaspberries = Number(d);
    let amountBerries = Number(e);

    let priceRaspberriesKg = priceStrawberries / 2;
    let priceOrangesKg = priceRaspberriesKg - (0.4 * priceRaspberriesKg);
    let priceBananaskg = priceRaspberriesKg - (0.8 * priceRaspberriesKg);

    let priceRaspberries = amountRaspberries * priceRaspberriesKg;
    let priceOrages = amountOranges * priceOrangesKg;
    let priceBananas = priceBananaskg * amountBananas;
    let priceBerries = amountBerries * priceStrawberries;

    let total = priceRaspberries + priceOrages + priceBananas + priceBerries;

    console.log(total.toFixed(2));
}
