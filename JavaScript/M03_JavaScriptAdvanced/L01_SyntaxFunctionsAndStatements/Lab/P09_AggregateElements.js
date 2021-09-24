function printElements(array) {
    let sumOfElements = 0;
    let sumOfInverseElements = 0;
    let sumOfStrings = '';
    for (let index = 0; index < array.length; index++) {
        const currElement = array[index];
        sumOfElements += currElement;
        sumOfInverseElements += 1 / currElement;
        sumOfStrings += currElement;
    }
    console.log(sumOfElements);
    console.log(sumOfInverseElements);
    console.log(sumOfStrings);
}
