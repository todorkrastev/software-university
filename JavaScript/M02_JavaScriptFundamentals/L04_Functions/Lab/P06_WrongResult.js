function wrongResult(numOne, numTwo, numThree) {
    let negativeCount = 0;
    let newArray = [numOne, numTwo, numThree];
    let isZero = false;

    for (const element of newArray) {

        if (element < 0) {
            negativeCount++;
        } else if (element === 0) {
            isZero = true;
            break;
        }
    }
    if ((negativeCount === 1 || negativeCount === 3) && isZero === false) {
        console.log("Negative");
    } else {
        console.log("Positive");

    }
}
