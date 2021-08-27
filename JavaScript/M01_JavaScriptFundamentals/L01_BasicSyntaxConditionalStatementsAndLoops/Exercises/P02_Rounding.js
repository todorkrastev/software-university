function rounding(number, precision) {
    let a = Number(number);
    let b = Number(precision);

    if (b > 15) {
        b = 15;
    }

    a = a.toFixed(b);
    console.log(parseFloat(a));
}
