function fruitShop(input) {
    let fruit = input[0];
    let dayOfWeek = input[1];
    let amount = input[2];
    let weekdays = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday"];
    let weekend = ["Saturday", "Sunday"];
    let validFruit = ["banana", "apple", "orange", "grapefruit", "kiwi", "pineapple", "grapes"];
    let totalPrice = 0.0;

    if (validFruit.includes(fruit)) {
        if (weekdays.includes(dayOfWeek)) {

            let price = {
                banana: 2.50,
                apple: 1.20,
                orange: 0.85,
                grapefruit: 1.45,
                kiwi: 2.70,
                pineapple: 5.50,
                grapes: 3.85,
            };

            totalPrice = price[fruit] * amount;

            console.log(totalPrice.toFixed(2));

        } else if (weekend.includes(dayOfWeek)) {

            let price = {
                banana: 2.70,
                apple: 1.25,
                orange: 0.90,
                grapefruit: 1.60,
                kiwi: 3.00,
                pineapple: 5.60,
                grapes: 4.20,
            };

            totalPrice = price[fruit] * amount;

            console.log(totalPrice.toFixed(2))

        } else {
            console.log("error");
        }
    } else {
        console.log("error");
    }
}
