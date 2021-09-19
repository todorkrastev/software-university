function accountBalance(input) {
    let i = 0, inp = '', total = 0;
    while (inp != "NoMoreMoney") {
        inp = input[i];
        i++;
        if (inp == "NoMoreMoney") {
            console.log(`Total: ${total.toFixed(2)}`);
            break;
        } else if (inp < 0) {
            console.log(`Invalid operation!` + '\n' +
                `Total: ${total.toFixed(2)}`);
            break;
        } else {
            total += Number(inp);
            console.log(`Increase: ${Number(inp).toFixed(2)}`);
        }
    }
}
