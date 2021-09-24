function arrayManipulations(arr) {
    let originalArr = arr[0].split(' ');
    let arrCopy = [...originalArr];

    let commands = arr.slice(1);

    let command = '';
    for (let i = 0; i < commands.length; i++) {
        command = commands[i];

        if (command.includes('Add')) {
            let numToAdd = command.split(' ')[1];
            arrCopy.push(numToAdd);
        } else if (command.includes('RemoveAt')) {
            let index = command.split(' ')[1];
            arrCopy.splice(index, 1);
        } else if (command.includes('Remove')) {
            let numToRemove = command.split(' ')[1];
            arrCopy = arrCopy.filter(num => num != numToRemove);
        } else if (command.includes('Insert')) {
            let numToInsert = command.split(' ')[1];
            let index = command.split(' ')[2];
            arrCopy.splice(index, 0, numToInsert);
        }
    }
    return arrCopy.join(' ');
}
