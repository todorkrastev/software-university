function birthdayParty(x) {
    let hallRent = Number(x);
    let priceCake = hallRent * 20 / 100;
    let priceDrink = priceCake - (priceCake * 0.45);
    let priceAnimator = hallRent / 3;
    let total = hallRent + priceCake + priceDrink + priceAnimator;

    console.log(total);
}
