function hotelRoom(input) {
    let month = input[0];
    let nights = parseInt(input[1]);

    let studioPct = 0, aptPct = 0, studioPrice = 0.0, aptPrice = 0.0; 

    switch (month) {
        case "May":
        case "October":
            studioPrice = 50;
            aptPrice = 65;
            if (nights > 14) {
                studioPct += 30
            } else if (nights > 7) {
                studioPct += 5
            }
            break;
        case "June":
        case "September":
            studioPrice = 75.20;
            aptPrice = 68.70;
            if (nights > 14) {
                studioPct += 20
            }
            break;
        case "July":
        case "August":
            studioPrice = 76;
            aptPrice = 77;
            break;
        default:
            break;
    }

    if (nights > 14) {
        aptPct += 10
    }

    studioPrice *= nights;
    aptPrice *= nights;

    studioPrice -= (studioPct / 100) * studioPrice;
    aptPrice -= (aptPct / 100) * aptPrice;

    console.log(`Apartment: ${aptPrice.toFixed(2)} lv.` + '\n' +
        `Studio: ${studioPrice.toFixed(2)} lv.`);
}
