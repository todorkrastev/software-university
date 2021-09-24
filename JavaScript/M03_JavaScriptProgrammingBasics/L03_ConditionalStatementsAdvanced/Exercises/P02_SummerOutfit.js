function summerOutfit(input) {
    let degrees = parseInt(input[0]);
    let timeOfDay = input[1];

    let normal = degrees >= 10 && degrees <= 18;
    let warm = degrees > 18 && degrees <= 24;
    let hot = degrees > 24;
    let outfit, shoes = "";

    switch (timeOfDay) {
        case "Morning":
            if (normal) {
                outfit = "Sweatshirt";
                shoes = "Sneakers";
            } else if (warm) {
                outfit = "Shirt";
                shoes = "Moccasins";
            } else if (hot) {
                outfit = "T-Shirt";
                shoes = "Sandals";
            }
            break;
        case "Afternoon":
            if (normal) {
                outfit = "Shirt";
                shoes = "Moccasins";
            } else if (warm) {
                outfit = "T-Shirt";
                shoes = "Sandals";
            } else if (hot) {
                outfit = "Swim Suit";
                shoes = "Barefoot";
            }
            break;
        case "Evening":
            outfit = "Shirt";
            shoes = "Moccasins";
            break;
        default:
            break;
    }
    console.log(`It's ${degrees} degrees, get your ${outfit} and ${shoes}.`)
}
