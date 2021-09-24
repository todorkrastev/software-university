function calculate(typeOfFruit, weightinGrams, pricePerKg) {
    let neededMoney = ((Number(weightinGrams) * Number(pricePerKg)) / 1000)
        .toFixed(2);
    let weightFromGrToKg = (weightinGrams / 1000)
        .toFixed(2);
    console.log(`I need $${neededMoney} to buy ${weightFromGrToKg} kilograms ${typeOfFruit}.`);
}
