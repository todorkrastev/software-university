function areaOfFigures(a, b, c) {
    let figure = a;
    let firstNum = Number(b);
    let secondNum = Number(c);

    if (figure === "square") {
        console.log((firstNum * firstNum).toFixed(3));
    } else if (figure === "rectangle") {
        console.log((firstNum * secondNum).toFixed(3));
    } else if (figure === "circle") {
        console.log((firstNum * firstNum * Math.PI).toFixed(3));
    } else if (figure === "triangle") {
        console.log((firstNum * secondNum / 2).toFixed(3));
    }
}
