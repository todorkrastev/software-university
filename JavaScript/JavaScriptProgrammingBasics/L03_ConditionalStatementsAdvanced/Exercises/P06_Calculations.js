function calculations(input) {
    let n1 = parseInt(input[0]);
    let n2 = parseInt(input[1]);
    let operator = input[2];

    let calc = n1 + ` ${operator} ` + n2;
    let result = 0;

    switch (operator) {
        case '+':
            result = n1 + n2;
            if (result % 2 == 0) {
                console.log(`${calc} = ${result} - even`);
            } else {
                console.log(`${calc} = ${result} - odd`);
            }
            break;
        case '-':
            result = n1 - n2;
            if (result % 2 == 0) {
                console.log(`${calc} = ${result} - even`);
            } else {
                console.log(`${calc} = ${result} - odd`);
            }
            break;
        case '*':
            result = n1 * n2;
            if (result % 2 == 0) {
                console.log(`${calc} = ${result} - even`);
            } else {
                console.log(`${calc} = ${result} - odd`);
            }
            break;
        case '/':
            result = n1 / n2;

            if (n2 != 0) {
                console.log(`${calc} = ${result.toFixed(2)}`);
            } else {
                console.log(`Cannot divide ${n1} by zero`);
            }
            break;
        case '%':
            result = n1 % n2;

            if (n2 != 0) {
                console.log(`${calc} = ${result}`);
            } else {
                console.log(`Cannot divide ${n1} by zero`);
            }
            break;
        default:
            break;
    }
}
