function solve(inputNum) {
    let maxNum = parseInt.MIN_VALUE;

    if (inputNum % 2 == 0) {
        maxNum = 2;
    }
    if (inputNum % 3 == 0) {
        maxNum = 3;
    }
    if (inputNum % 6 == 0) {
        maxNum = 6;
    }
    if (inputNum % 7 == 0) {
        maxNum = 7;
    }
    if (inputNum % 10 == 0) {
        maxNum = 10;
    }
    if (inputNum % 2 != 0 && inputNum % 3 != 0 && inputNum % 6 != 0 && inputNum % 7 != 0 && inputNum % 10 != 0) {
        console.log("Not divisible");
        return;
    }
    console.log("The number is divisible by " + maxNum);
}
