function workTime(input) {
    let hour = parseInt(input[0]);
    let day = input[1];

    weekdays = {
        workdays: ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"],
        weekend: ["Sunday"]
    }

    let isWeekday = weekdays.workdays.includes(day);
    let openHours = hour >= 10 && hour <= 18;
    let isOpen = isWeekday && openHours;

    return isOpen ? console.log("open") : console.log("closed")
}
