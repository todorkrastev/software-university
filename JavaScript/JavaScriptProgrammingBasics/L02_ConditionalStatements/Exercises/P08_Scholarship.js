function scholarship(a, b, c) {
    let incomeInBgn = Number(a);
    let averageSuccess = Number(b);
    let minimalSalary = Number(c);

    let socSch = Math.floor(minimalSalary * 0.35);
    let socExcelRes = Math.floor(averageSuccess * 25);

    if (incomeInBgn < minimalSalary && averageSuccess > 4.5 && averageSuccess < 5.50) {
        console.log(`You get a Social scholarship ${socSch} BGN`)

    } else if (averageSuccess >= 5.50 && incomeInBgn < minimalSalary) {
        if (socSch > socExcelRes) {
            console.log(`You get a Social scholarship ${socSch} BGN`)
        } else {
            console.log(`You get a scholarship for excellent results ${socExcelRes} BGN`)
        }

    } else if (averageSuccess >= 5.50) {
        console.log(`You get a scholarship for excellent results ${socExcelRes} BGN`)
    } else {
        console.log(`You cannot get a scholarship!`)
    }
}
