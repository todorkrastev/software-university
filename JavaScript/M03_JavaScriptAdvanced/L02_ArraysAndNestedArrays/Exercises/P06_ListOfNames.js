function sortNamesAlphabetically(arrayStr) {
    return arrayStr
        .sort((a, b) => a.localeCompare(b))
        .forEach((e, i) => console.log(`${i + 1}.${e}`));
}
