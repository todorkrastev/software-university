function sumFirstAndLastArrayElements(input) {
    let firstNum = Number(input.shift());
    let lastNum = Number(input.pop());

    console.log(firstNum + lastNum);
}
