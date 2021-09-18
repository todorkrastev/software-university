
function equalArrays(a, b) {
    let firstArray = a;
    let secondArray = b;
    let total = 0;
    let errorIndex = 0;
    let flag = false;

    for (let i = 0; i < firstArray.length; i++) {
        let numOne = Number(firstArray[i]);
        let numTwo = Number(secondArray[i]);

        if (numOne === numTwo) {
            total += numOne;
        } else {
            flag = true;
            break;
        }
        errorIndex++;
    }
    if (flag) {
        console.log(`Arrays are not identical. Found difference at ${errorIndex} index`);
    } else {
        console.log(`Arrays are identical. Sum: ${total}`);
    }
}
