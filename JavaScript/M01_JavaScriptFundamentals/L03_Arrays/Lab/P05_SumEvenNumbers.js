function sumEvenNumbers(num) {
    let sumEven = 0;

    for (let i = 0; i < num.length; i++) {
        let nummer = Number(num[i]);
        if (nummer % 2 === 0) {
            sumEven += nummer;
        }
    }
    console.log(sumEven);
}
