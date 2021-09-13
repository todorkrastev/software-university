function pieceOfPie(strArr, firstStr, secondStr) {
    let startIndex = 0;
    let endIndex = 0;
    if (strArr.includes(firstStr) && strArr.includes(secondStr)) {
        startIndex = strArr.indexOf(firstStr);
        endIndex = strArr.indexOf(secondStr);
    }
    let arrToPrint = strArr.slice(startIndex, endIndex + 1);
    return arrToPrint;
}
