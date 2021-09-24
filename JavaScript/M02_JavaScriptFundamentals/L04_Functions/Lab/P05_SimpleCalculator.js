function simpleCalculator(firstNum, secondNum, operator) {
    switch (operator) {
        case "multiply":
            console.log(firstNum * secondNum);
            break;
        case "divide":
            console.log(firstNum / secondNum);
            break;
        case "add":
            console.log(firstNum + secondNum);
            break;
        case "subtract":
            console.log(firstNum - secondNum);
            break;
    }
}
