function sumPrimeNonPrime(input) {
    let sumPrimeNums = 0;
    let sumNonPrimeNums = 0;
    let num = 0;

    for (let i = 0; i <= input.length; i++) {
        if (isNaN(input[i])) {
            if (input[i] === "stop") {
                console.log(`Sum of all prime numbers is: ${sumPrimeNums}` + '\n' +
                    `Sum of all non prime numbers is: ${sumNonPrimeNums}`);
                break;
            }
        } else if (input[i] < 0) {
            console.log("Number is negative.");
            continue;
        } else if (input[i] === 1) {
            sumPrimeNums++;
            continue;
        }
        num = parseInt(input[i]);

        let isPrime = true;
        for (let x = 2; x <= Math.sqrt(num); x++) {
            if (num % x === 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            sumPrimeNums += num;
        } else {
            sumNonPrimeNums += num;
        }
    }
}
