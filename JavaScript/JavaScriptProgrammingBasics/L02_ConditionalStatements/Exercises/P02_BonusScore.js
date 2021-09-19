function bonusScore(a) {
    let bonus = 0;
    let num = Number(a);

    if (num <= 100) {
        bonus += 5;
    } else if (num > 100 && num <= 1000) {
        bonus += num * 0.20;
    } else {
        bonus += num * 0.10;
    }

    if (num % 2 === 0) {
        bonus += 1;
    }
    if (num % 10 === 5) {
        bonus += 2;
    }
    console.log(bonus);
    console.log(num + bonus);
}
