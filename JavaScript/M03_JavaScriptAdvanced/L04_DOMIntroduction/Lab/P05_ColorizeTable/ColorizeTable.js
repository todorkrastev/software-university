function colorize() {
    const rows = document.querySelectorAll('table tr');

    for (let index = 1; index < rows.length; index += 2) {
        rows[index].style.backgroundColor = 'teal';
    }

    //second option
    /* const rows = document.querySelectorAll('table tr:nth-child(even)');

    for (let index = 0; index < rows.length; index++) {
        rows[index].style.backgroundColor = 'teal';
    } */

    //third option
    /* let table = Array.from(document.getElementsByTagName("tr"))

    table = table.map((x, i) => {
        if (i % 2 !== 0) {
            x.style.backgroundColor = "teal"
        }
        return x
    }) */
}
