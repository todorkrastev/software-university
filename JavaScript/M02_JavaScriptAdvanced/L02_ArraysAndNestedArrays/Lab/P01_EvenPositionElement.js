function printEvenLement(inputArr) {
    let result = [];
    for (let index = 0; index < inputArr.length; index += 2) {
        result[result.length] = inputArr[index];
    }
    return result.join(' ');
}
