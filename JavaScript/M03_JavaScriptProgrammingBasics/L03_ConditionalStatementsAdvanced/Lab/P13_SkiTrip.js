function skiTrip(input) {
    let days = parseInt(input[0]);
    let aptType = input[1];
    let rating = input[2];

    let stayLength = [days < 10, days >= 10 && days <= 15, days > 15];
    let nightPrice = 0.0, price = 0.0, discount = 0.0, totalPrice = 0.0, tip = 0.0;

    switch (aptType) {
        case "room for one person":
            nightPrice = 18.0;
            totalPrice = nightPrice * (days - 1);
            break;
        case "apartment":
            nightPrice = 25.0;
            price = nightPrice * (days - 1);

            if (stayLength[0]) {
                discount = (30 / 100) * price;
            } else if (stayLength[1]) {
                discount = (35 / 100) * price;
            } else if (stayLength[2]) {
                discount = (50 / 100) * price;
            }

            totalPrice = price - discount;
            break;
        case "president apartment":
            nightPrice = 35.0;
            price = nightPrice * (days - 1);

            if (stayLength[0]) {
                discount = (10 / 100) * price;
            } else if (stayLength[1]) {
                discount = (15 / 100) * price;
            } else if (stayLength[2]) {
                discount = (20 / 100) * price;
            }

            totalPrice = price - discount;
            break;
        default:
            break;
    }

    if (rating == "positive") {
        tip = (25 / 100) * totalPrice;
        totalPrice += tip;
    } else {
        totalPrice -= (10 / 100) * totalPrice;
    }

    console.log(totalPrice.toFixed(2));
}
