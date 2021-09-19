function metricConverter(a, b, c) {
    let num = Number(a)
    let inputMeasure = b
    let outputMeasure = c

    if (inputMeasure === "mm" && outputMeasure === "m") {
        console.log((num / 1000).toFixed(3));
    } else if (inputMeasure === "mm" && outputMeasure === "cm") {
        console.log((num / 10).toFixed(3));

    } else if (inputMeasure === "m" && outputMeasure === "cm") {
        console.log((num * 100).toFixed(3));
    } else if (inputMeasure === "m" && outputMeasure === "mm") {
        console.log((num * 1000).toFixed(3));

    } else if (inputMeasure === "cm" && outputMeasure === "mm") {
        console.log((num * 10).toFixed(3));
    } else if (inputMeasure === "cm" && outputMeasure === "m") {
        console.log((num / 100).toFixed(3));
    }
}
