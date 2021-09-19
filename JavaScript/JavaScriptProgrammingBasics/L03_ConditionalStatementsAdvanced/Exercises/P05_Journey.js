function journey(input) {
    let budget = parseFloat(input[0]);
    let season = input[1];

    let Bulgaria = budget <= 100;
    let Balkans = budget > 100 && budget <= 1000;
    let Europe = budget > 1000;

    let isSummer = season == "summer";
    let isWinter = season == "winter";

    let accomodation = "";
    if (isWinter || Europe) {
        accomodation = "Hotel";
    } else if (isSummer) {
        accomodation = "Camp";
    }

    let pct = 0;
    let location = "";
    if (Bulgaria) {
        location = "Bulgaria";
        if (isSummer) {
            pct = 30;
        } else if (isWinter) {
            pct = 70;
        }
    } else if (Balkans) {
        location = "Balkans";
        if (isSummer) {
            pct = 40;
        } else if (isWinter) {
            pct = 80;
        }
    } else if (Europe) {
        location = "Europe";
        pct = 90;
    }

    let price = ((pct / 100) * budget).toFixed(2);

    console.log(`Somewhere in ${location}` + '\n'
        + `${accomodation} - ${price}`);
}
