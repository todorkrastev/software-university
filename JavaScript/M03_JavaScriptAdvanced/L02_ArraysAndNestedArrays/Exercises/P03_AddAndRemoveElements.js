function printElements(arrayStr) {
    let printArr = [];
    arrayStr.forEach((e, i) => e === 'remove' ? printArr.pop() : printArr.push(i + 1));
    return printArr.length === 0 ? 'Empty' : printArr.join('\r\n');
}
