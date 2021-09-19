function cinema(input) {
    let type = input[0];
    let rows = parseInt(input[1]);
    let cols = parseInt(input[2]);
    let cinemaSize = rows * cols;
    let income = 0.0;

    switch (type) {
        case "Premiere":
            income = cinemaSize * 12.0;
            break;
        case "Normal":
            income = cinemaSize * 7.5;
            break;
        case "Discount":
            income = cinemaSize * 5.0;
            break;
        case "default":
            break;
    }
    console.log(income.toFixed(2) + " leva");
}
