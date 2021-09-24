function validateEqualityOfNumbers(input) {
    let inputToStr = input.toString();
    let sumOfDigits = 0;
    let isEqual = true;
    for (let index = 0; index < inputToStr.length; index++) {
        const currElement = inputToStr[index];
        sumOfDigits += Number(currElement);
        if (index !== inputToStr.length - 1) {
            const nextElement = inputToStr[index + 1];
            if (currElement !== nextElement) {
                isEqual = false;
            }
        }
    }
    isEqual ? console.log('true') : console.log('false');
    console.log(sumOfDigits);
}
validateEqualityOfNumbers(2222222);
validateEqualityOfNumbers(1234);