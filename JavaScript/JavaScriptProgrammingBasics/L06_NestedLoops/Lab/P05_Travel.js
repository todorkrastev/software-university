function travel(input) {

    let destination = ``, curr_destination = ``, budget = ``, wallet = 0, printed = false;
    for (let i = 0; i < input.length; i++) {
        if (isNaN(input[i])) {
            if (input === "End") { break; }

            wallet = 0; printed = false;
            destination = input[i];

            if (curr_destination != destination) {
                curr_destination = destination;
                budget = parseFloat(input[i + 1]);
            }
            continue;
        }

        if (wallet >= budget && !printed) {
            console.log(`Going to ${destination}!`);
            printed = true;
        }
        wallet += parseFloat(input[i]);
    }
}
