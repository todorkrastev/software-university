function subtract() {
    let num1 = document.getElementById('firstNumber').value;
    let num2 = document.getElementById('secondNumber').value;

    let subtract = Number(num1) - Number(num2);
    document.getElementById('result').innerHTML = subtract.toString();

    // second option

    // const html = {
    //     firstV: document.getElementById("firstNumber"),
    //     secondV: document.getElementById("secondNumber"),
    //     result: document.getElementById("result"),
    // }

    // html.result.innerHTML =
    //     (Number(html.firstV.value) || 0) - (Number(html.secondV.value) || 0)
}
