function solve(input) {
    let user = input.shift();
    let password = user.split('').reverse().join('');
    let count = 0;
    while (true) {
        let enter = input.shift();
        if (enter === password) {
            console.log(`User ${user} logged in.`);
            break;
        } else if (count >= 3) {
            console.log(`User ${user} blocked!`);
            break;
        } else {
            console.log('Incorrect password. Try again.');
            count++;
        }
    }
}
