function matchDates(arr) {
    let pattern = /\b(?<day>\d{2})([\/\-.])(?<month>[A-Z]{1}[a-z]{2})\2(?<year>\d{4})/g;
    let dates = arr.shift();

    while ((validDate = pattern.exec(dates)) != null) {
        let d = validDate.groups.day;
        let m = validDate.groups.month;
        let y = validDate.groups.year;

        console.log(`Day: ${d}, Month: ${m}, Year: ${y}`);
    }
}
