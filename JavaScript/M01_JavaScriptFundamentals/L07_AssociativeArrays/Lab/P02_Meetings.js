function foo(input) {
    let scheduledMeetings = {};

    for (let i = 0; i < input.length; i++) {
        let splitInput = input[i].split(' ');
        let weekday = splitInput.shift();
        let name = splitInput.shift();

        if (scheduledMeetings.hasOwnProperty(weekday)) {
            console.log(`Conflict on ${weekday}!`);
        } else {
            scheduledMeetings[weekday] = name;
            console.log(`Scheduled for ${weekday}`);
        }
    }

    return (Object.entries(scheduledMeetings)
        .map(entry => `${entry[0]} -> ${entry[1]}`)
        .join('\n'));
}
