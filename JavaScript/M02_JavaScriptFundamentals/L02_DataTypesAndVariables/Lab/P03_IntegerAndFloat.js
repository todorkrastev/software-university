function solve(firstNum, secondNum, thirdNum) {
    let sum = firstNum + secondNum + thirdNum;
    sum % 1 === 0 ? sum += ' - Integer' : sum += ' - Float';
    console.log(sum);
}
