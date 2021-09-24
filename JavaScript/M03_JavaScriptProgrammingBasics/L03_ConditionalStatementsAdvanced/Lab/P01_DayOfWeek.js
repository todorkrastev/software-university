function dayOfTheWeek(input) {
    let num = parseInt(input[0]);

    let day = {
        1: "Monday",
        2: "Tuesday",
        3: "Wednesday",
        4: "Thursday",
        5: "Friday",
        6: "Saturday",
        7: "Sunday"
    }

    if (day[num]) {
        let theDay = day[num];
        console.log(theDay);
    } else {
        console.log("Error");
    }
}
