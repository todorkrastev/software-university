function trainTheTrainers(input) {
    let index = 0;
    let n = Number(input[index++]);
    let command = "";
    let count = 0, totalAverageGrade = 0;
    while (command != "Finish") {
        command = input[index++];
        if (command === "Finish") {
            totalAverageGrade /= count;
            console.log(`Student's final assessment is ${totalAverageGrade.toFixed(2)}.`);
            break;
        }
        let presentationName = command;
        let averageGrade = 0;
        for (let i = 0; i < n; i++) {
            let grade = Number(input[index++]);
            averageGrade += grade;
            totalAverageGrade += grade;
            count++;
        }
        averageGrade = averageGrade / n;
        console.log(`${presentationName} - ${averageGrade.toFixed(2)}.`);
    }
}
