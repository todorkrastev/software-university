function yardGreening(num) {
    let priceGrass = num * 7.61;
    let discount = 0.18 * priceGrass;
    let totalPrice = priceGrass - discount;

    console.log(`The final price is: ${totalPrice} lv.`);
    console.log(`The discount is: ${discount} lv.`);
}
