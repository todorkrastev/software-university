function calculate(typeOfFruit, weightinGrams, pricePerKg) {
    let neededMoney = ((Number(weightinGrams) * Number(pricePerKg)) / 1000)
        .toFixed(2);
    let weightFromGrToKg = (weightinGrams / 1000)
        .toFixed(2);
    console.log(`I need $${neededMoney} to buy ${weightFromGrToKg} kilograms ${typeOfFruit}.`);

  /*  const kg = x / 1000
    return `I need $${(kg * y).toFixed(2)} to buy ${kg.toFixed(2)} kilograms ${a}.` */
}
