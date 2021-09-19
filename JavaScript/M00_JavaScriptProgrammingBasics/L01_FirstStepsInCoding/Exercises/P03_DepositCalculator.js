function depositCalculator(x, y, z) {
    let depositedAmount = Number(x);
    let depositTermMonths = Number(y);
    let annualInterestRate = Number(z);

    let calculateInterest = depositedAmount * annualInterestRate / 100;
    let calculateInterestMonths = calculateInterest / 12;
    let total = depositedAmount + (depositTermMonths * calculateInterestMonths);

    console.log(total);
}
