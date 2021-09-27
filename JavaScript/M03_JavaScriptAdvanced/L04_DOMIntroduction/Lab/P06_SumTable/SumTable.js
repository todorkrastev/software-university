function sumTable() {
    const rows = document.querySelectorAll('table tr');
    let sum = 0;

    for (let index = 1; index < rows.length - 1; index++) {
        const cell = rows[index].lastElementChild;
        sum += Number(cell.textContent);
    }
    document.getElementById('sum').textContent = sum;

      //second option
    /* let dataCells = Array.from(document.getElementsByTagName("td"))

    document.getElementById("sum").innerHTML = dataCells
        .slice(0, dataCells.length - 1)
        .reduce((a, v) => a + (Number(v.innerHTML) || 0), 0) */
}