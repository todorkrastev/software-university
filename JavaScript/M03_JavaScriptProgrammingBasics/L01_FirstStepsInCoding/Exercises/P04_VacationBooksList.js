function requiredLiterature(x, y, z) {
    let numberPages = Number(x);
    let pagesRead = Number(y);
    let numberDays = Number(z);

    let totalReadingTime = numberPages / pagesRead;
    let total = totalReadingTime / numberDays;

    console.log(total);
}
