function walking(input) {

    let goal = 10000, inp = '', totalSteps = 0;

    while (inp != "Going home") {
        inp = input[i];

        if (inp == "Going home") {
            inp = parseInt(input[i += 1]);
            totalSteps += inp;

            if (totalSteps >= goal) {
                console.log(`Goal reached! Good job!` + '\n' +
                    `${totalSteps - goal} steps over the goal!`);
                break;
            } else {
                console.log(`${goal - totalSteps} more steps to reach goal.`);
                break;
            }
        }
        if (totalSteps >= goal) {
            console.log(`Goal reached! Good job!` + '\n' +
                `${totalSteps - goal} steps over the goal!`);
            break;
        }
        totalSteps += parseInt(inp);
        i++;
    }
}
