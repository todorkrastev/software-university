function getResult(firstNum, secondNum, operator) {
    let result;
    switch (operator) {
        case '+':
            result = firstNum + secondNum;
            break;
        case '-':
            result = firstNum - secondNum;
            break;
        case '*':
            result = firstNum * secondNum;
            break;
        case '/':
            result = firstNum / secondNum;
            break;
        case '%':
            result = firstNum % secondNum;
            break;
        case '**':
            result = firstNum ** secondNum;
            break;
        default:
            break;
    }
    console.log(result);
}
