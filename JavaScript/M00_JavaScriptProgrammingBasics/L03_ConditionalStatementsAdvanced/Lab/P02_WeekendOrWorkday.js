function weekendOrWorkday(input) {
    let day = input[0];

    weekdays = {
        workdays: ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday"],
        weekend: ["Saturday", "Sunday"]
    }

    if (weekdays.workdays.includes(day)) {
        console.log("Working day");
    }
    else if (weekdays.weekend.includes(day)) {
        console.log("Weekend");
    }
    else {
        console.log("Error");
    }
}
