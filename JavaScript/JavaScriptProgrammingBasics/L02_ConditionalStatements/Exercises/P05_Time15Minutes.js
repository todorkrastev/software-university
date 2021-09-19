function timeMinutes(a, b) {
    let hours = Number(a);
    let minutes = Number(b);

    let totalMinutes = minutes + 15;

    if (totalMinutes >= 60) {
        hours += Math.floor(totalMinutes / 60);
        minutes = totalMinutes % 60;
    } else {
        minutes += 15;
    }

    if (hours > 23 && minutes < 10) {
        console.log(`${0}:0${minutes}`);

    } else if (hours > 23) {
        console.log(`${0}:${minutes}`);

    } else if (minutes < 10) {
        console.log(`${hours}:0${minutes}`);
    } else {
        console.log(`${hours}:${minutes}`);
    }
}
