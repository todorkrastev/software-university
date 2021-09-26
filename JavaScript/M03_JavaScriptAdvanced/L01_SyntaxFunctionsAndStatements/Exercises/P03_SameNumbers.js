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

    /*   const arr = `${n}`.split("")
       return `${arr.every((x, i, arr1) => arr1.slice(i).every(y => x === y))}
   ${arr.map(Number).reduce((a, v) => a + v, 0)}` */
}
