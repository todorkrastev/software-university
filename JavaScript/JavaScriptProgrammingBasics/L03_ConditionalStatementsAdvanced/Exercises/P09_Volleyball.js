function volleyball(input) {
    let yearType = input[0];
    let holidays = Number(input[1]);
    let travelDays = Number(input[2]);
    let weekends = 48;

    let playDays = 0;
    playDays += (3 / 4) * (weekends - travelDays);
    playDays += (2 / 3) * holidays;
    playDays += travelDays;

    if (yearType == "leap") {
        playDays += (15 / 100) * playDays;
    }
    console.log(Math.floor(playDays));
}
