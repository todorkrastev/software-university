function newHouse(input) {
    let flowerType = input[0];
    let numOfFlowers = parseInt(input[1]);
    let budget = parseInt(input[2]);

    let flowersPrice = {
        Roses: 5,
        Dahlias: 3.80,
        Tulips: 2.80,
        Narcissus: 3,
        Gladiolus: 2.50
    }

    let price = flowersPrice[flowerType] * numOfFlowers;

    let discount = 0.0;
    switch (flowerType) {
        case "Roses":
            if (numOfFlowers > 80) {
                discount = (10 / 100) * price;
            }
            break;
        case "Dahlias":
            if (numOfFlowers > 90) {
                discount = (15 / 100) * price;
            }
            break;
        case "Tulips":
            if (numOfFlowers > 80) {
                discount = (15 / 100) * price;
            }
            break;
        case "Narcissus":
            if (numOfFlowers < 120) {
                price += (15 / 100) * price;
            }
            break;
        case "Gladiolus":
            if (numOfFlowers < 80) {
                price += (20 / 100) * price;
            }
            break;
        default:
            break;
    }

    price -= discount;

    if (budget >= price) {
        let moneyLeft = budget - price;
        console.log(`Hey, you have a great garden with ${numOfFlowers} ${flowerType} and ${moneyLeft.toFixed(2)} leva left.`)
    } else {
        let moneyNeeded = price - budget;
        console.log(`Not enough money, you need ${moneyNeeded.toFixed(2)} leva more.`)
    }
}
