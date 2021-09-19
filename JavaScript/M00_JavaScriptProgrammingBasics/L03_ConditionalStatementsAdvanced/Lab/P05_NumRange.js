function numRange(input) {
    let num = Number(input[0]);
    let validRange = num >= -100 && num <= 100 && num != 0;

    validRange ? console.log("Yes") : console.log("No");
}
