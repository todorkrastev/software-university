function leapYears(input) {
    let leapYear = parseInt(input[0]);
    let rdmYear = parseInt(input[1]);

    for (let i = leapYear; i <= rdmYear; i += 4) {
        console.log(i);
    }
}
