function printElement(arrayStr, nth) {
    let array = [];
    array = arrayStr.filter((e, i) => i % nth === 0);
    return array;
}
