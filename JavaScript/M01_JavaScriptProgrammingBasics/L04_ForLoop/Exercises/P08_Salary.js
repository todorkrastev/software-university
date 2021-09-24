function salaryCalculator(input) {
    let tabsCount = parseInt(input[0]);
    let salary = Number(input[1]);

    let siteName = '';
    for (let i = 1; i <= tabsCount; i++) {
        siteName = input[i + 1];

        if (siteName == "Facebook") {
            salary -= 150;
        } else if (siteName == "Instagram") {
            salary -= 100;
        } else if (siteName == "Reddit") {
            salary -= 50;
        }

        if (salary <= 0) {
            console.log(`You have lost your salary.`);
            break;
        }
    }
    if (salary > 0) {
        console.log(salary);
    }
}
