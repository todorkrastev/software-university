function onTimeForTheExam(input) {
    let hoursExam = Number(input[0]);
    let minsExam = Number(input[1]);
    let arrivalHours = Number(input[2]);
    let arrivalMins = Number(input[3]);

    let examTimeInMins = hoursExam * 60 + minsExam;
    let arrivalTimeInMins = arrivalHours * 60 + arrivalMins;

    let diff = 0, hours = 0, mins = 0;
    if (examTimeInMins == arrivalTimeInMins) {
        console.log(`On time`);
    } else if (arrivalTimeInMins > examTimeInMins) { // If late
        diff = arrivalTimeInMins - examTimeInMins;

        if (diff < 60) {
            mins = diff;

            console.log(`late` + '\n' +
                `${mins} minutes after the start`);

        } else if (diff == 60) {

            console.log(`late` + '\n' +
                `1:00 hours after the start`);

        } else if (diff > 60) {
            hours = Math.floor(diff / 60);
            mins = diff % 60;
            if (mins <= 10) { mins = `0${mins}` }

            console.log(`late` + '\n' +
                `${hours}:${mins} hours after the start`);
        }

    } else { // If not late
        diff = examTimeInMins - arrivalTimeInMins;

        if (diff <= 30) {
            mins = diff;

            console.log(`on time` + '\n' +
                `${mins} minutes before the start`);

        } else if (diff > 30 && diff < 60) {
            mins = diff;

            console.log(`early` + '\n' +
                `${mins} minutes before the start`);
        } else if (diff == 60) {

            console.log(`early` + '\n' +
                `1:00 hours before the start`);
        } else if (diff > 60) {
            hours = Math.floor(diff / 60);
            mins = diff % 60;
            if (mins <= 10) { mins = `0${mins}` }

            console.log(`early` + '\n' +
                `${hours}:${mins} hours before the start`);
        }
    }
}