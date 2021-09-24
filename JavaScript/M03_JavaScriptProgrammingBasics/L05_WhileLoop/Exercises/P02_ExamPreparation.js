function examPreparation(input) {
    let index = 0;
    let limit = parseInt(input[index++]);

    let exc = '', grade = 0.0;
    let badGrades = [], sum = 0, lastExc = '', numProblems = 0;

    while (exc != "Enough") {
        exc = input[index++];
        grade = Number(input[index++]);

        if (grade <= 4) {
            badGrades.push(grade);
        }

        if (exc == "Enough") {
            let average = sum / numProblems;
            console.log(`Average score: ${average.toFixed(2)}` + '\n' +
                `Number of problems: ${numProblems}` + '\n' +
                `Last problem: ${lastExc}`);
            break;
        } else if (badGrades.length == limit) {
            console.log(`You need a break, ${badGrades.length} poor grades.`);
            break;
        }

        lastExc = exc;
        sum += grade;
        numProblems++;
    }
}
