function smallShop(input) {
    let product = input[0];
    let city = input[1];
    let amount = Number(input[2]);
    let price;

    switch (product) {
        case "coffee":
            switch (city) {
                case "Sofia":
                    price = 0.50;
                    console.log(amount * price);
                    break;
                case "Plovdiv":
                    price = 0.40;
                    console.log(amount * price);
                    break;
                case "Varna":
                    price = 0.45;
                    console.log(amount * price);
                    break;
            }
            break;
        case "water":
            switch (city) {
                case "Sofia":
                    price = 0.80;
                    console.log(amount * price);
                    break;
                case "Plovdiv":
                    price = 0.70;
                    console.log(amount * price);
                    break;
                case "Varna":
                    price = 0.70;
                    console.log(amount * price);
                    break;
            }
            break;
        case "beer":
            switch (city) {
                case "Sofia":
                    price = 1.20;
                    console.log(amount * price);
                    break;
                case "Plovdiv":
                    price = 1.15;
                    console.log(amount * price);
                    break;
                case "Varna":
                    price = 1.10;
                    console.log(amount * price);
                    break;
            }
            break;
        case "sweets":
            switch (city) {
                case "Sofia":
                    price = 1.45;
                    console.log(amount * price);
                    break;
                case "Plovdiv":
                    price = 1.30;
                    console.log(amount * price);
                    break;
                case "Varna":
                    price = 1.35;
                    console.log(amount * price);
                    break;
            }
            break;
        case "peanuts":
            switch (city) {
                case "Sofia":
                    price = 1.60;
                    console.log(amount * price);
                    break;
                case "Plovdiv":
                    price = 1.50;
                    console.log(amount * price);
                    break;
                case "Varna":
                    price = 1.55;
                    console.log(amount * price);
                    break;
            }
            break;
        default:
            break;
    }
}
