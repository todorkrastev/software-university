function grades(num) {
    if (num >= 2.00 && num <= 2.99) {
        console.log(`Fail`);
    } else if (num >= 3.00 && num <= 3.49) {
        console.log(`Poor`);
    } else if (num >= 3.50 && num <= 4.49) {
        console.log(`Good`);
    } else if (num >= 4.50 && num <= 5.49) {
        console.log(`Very good`);
    } else if (num >= 5.50 && num <= 6.00) {
        console.log(`Excellent`);
    }
}
