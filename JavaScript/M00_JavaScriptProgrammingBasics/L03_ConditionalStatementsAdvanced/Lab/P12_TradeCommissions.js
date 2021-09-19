function tradeCommissions(input) {
    let city = input[0];
    let sales = Number(input[1]);
    let volSalesOne = sales >= 0 && sales <= 500;
    let volSalesTwo = sales > 500 && sales <= 1000;
    let volSalesThree = sales > 1000 && sales <= 10000;
    let volSalesFour = sales > 10000;
    let validCities = ["Sofia", "Varna", "Plovdiv"];
    let price, pct;

    if (validCities.includes(city) && sales >= 0) {
        if (volSalesOne) {
            switch (city) {
                case validCities[0]:
                    pct = 5;
                    price = (pct / 100) * sales;
                    console.log(price.toFixed(2));
                    break;
                case validCities[1]:
                    pct = 4.5;
                    price = (pct / 100) * sales;
                    console.log(price.toFixed(2));
                    break;
                case validCities[2]:
                    pct = 5.5;
                    price = (pct / 100) * sales;
                    console.log(price.toFixed(2));
                    break;
                default:
                    break;
            }
        } else if (volSalesTwo) {
            switch (city) {
                case validCities[0]:
                    pct = 7;
                    price = (pct / 100) * sales;
                    console.log(price.toFixed(2));
                    break;
                case validCities[1]:
                    pct = 7.5;
                    price = (pct / 100) * sales;
                    console.log(price.toFixed(2));
                    break;
                case validCities[2]:
                    pct = 8;
                    price = (pct / 100) * sales;
                    console.log(price.toFixed(2));
                    break;
                default:
                    break;
            }

        } else if (volSalesThree) {
            switch (city) {
                case validCities[0]:
                    pct = 8;
                    price = (pct / 100) * sales;
                    console.log(price.toFixed(2));
                    break;
                case validCities[1]:
                    pct = 10;
                    price = (pct / 100) * sales;
                    console.log(price.toFixed(2));
                    break;
                case validCities[2]:
                    pct = 12;
                    price = (pct / 100) * sales;
                    console.log(price.toFixed(2));
                    break;
                default:
                    break;
            }

        } else if (volSalesFour) {
            switch (city) {
                case validCities[0]:
                    pct = 12;
                    price = (pct / 100) * sales;
                    console.log(price.toFixed(2));
                    break;
                case validCities[1]:
                    pct = 13;
                    price = (pct / 100) * sales;
                    console.log(price.toFixed(2));
                    break;
                case validCities[2]:
                    pct = 14.5;
                    price = (pct / 100) * sales;
                    console.log(price.toFixed(2));
                    break;
                default:
                    break;
            }
        }
    } else {
        console.log("error");
    }
}