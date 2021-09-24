function orders(product, quantity) {
    let total = 0;
    if (product === "water") {
        total = quantity;
    } else if (product === "coffee") {
        total = quantity * 1.50;
    } else if (product === "coke") {
        total = quantity * 1.40;
    } else if (product === "snacks") {
        total = quantity * 2.00;
    }
    console.log(total.toFixed(2));
}