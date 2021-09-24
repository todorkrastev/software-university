function graduationPt2(input) {
    let name = input[0];

    let index = 1, grade = 4, sum = 0;
    while (grade >= 4 && index <= 12) {
        let grade = input[index];
        sum += parseFloat(grade);
        if (grade < 4) {
            console.log(`${name} has been excluded at ${index} grade`); break;
        }
        else if (index == 12) {
            let average = sum / 12;
            console.log(`${name} graduated. Average grade: ${average.toFixed(2)}`);
        }
        index++;
    }
}
