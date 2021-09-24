function sortArr(arrStr) {
    return arrStr
        .sort((a, b) => a.length - b.length || a.localeCompare(b))
        .forEach((e) => console.log(e));
}
