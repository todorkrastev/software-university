function vacation(input) {
    let index = 0;
    let vacationCost = parseFloat(input[index++]);
    let wallet = parseFloat(input[index++]);

    let action = '', actions = [], sum = 0, counter = 0;

    while (wallet <= vacationCost) {
        action = input[index++];
        sum = parseFloat(input[index++]);
        counter++;

        if (action == "spend" && sum >= wallet) { wallet = 0; }
        else if (action == "spend") {
            wallet -= sum;
            actions.push("spend");
        } else if (action == "save") {
            actions.length = 0;
            wallet += sum;
        }
        if (actions.length == 5) {
            console.log(`You can't save the money.` + '\n' +
                `${counter}`);
            break;
        } else if (wallet >= vacationCost) {
            console.log(`You saved the money for ${counter} days.`);
            break;
        }
    }
}
