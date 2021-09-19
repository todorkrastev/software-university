function coins(input) {
    let num = Math.round(parseFloat(input) * 100);
    let coinsArr = [1, 2, 5, 10, 20, 50, 100, 200];
    let max = Math.max(...coinsArr);
    let totalCoins = 0;

    while (num > 0) {
        if (num === 0) { break; }
        if (num >= max) {
            num -= max;
            totalCoins++;
        } else { // if it's less than max, one of the other coins applies
            let newArr = coinsArr.splice(coinsArr.indexOf(max), 1); // remove the previous max
            max = Math.max(...newArr); // get the new one
        }
    }
    console.log(totalCoins);
}
