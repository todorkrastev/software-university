function calc(event) {
    console.log(event)

    const num1 = Number(document.getElementById('num1').value);
    const num2 = Number(document.getElementById('num2').value);

    const sum = num1 + num2;

    Number.isNaN(sum) ? document.getElementById('sum').value = 'Error!' : document.getElementById('sum').value = sum;

    //second option
    /* const html = {
        getNumField: n => document.getElementById(`num${n}`),
        result: () => document.getElementById("sum"),
    }
    const getNum = e => Number(e.value)

    html.result().value =
        getNum(html.getNumField(1)) + getNum(html.getNumField(2)) */
}
