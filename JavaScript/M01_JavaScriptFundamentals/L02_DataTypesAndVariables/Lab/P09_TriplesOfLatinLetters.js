function trippleLetters(number) {
    let n = parseInt(number);
    for (let i = 97; i < 97 + n; i++) {
        let firstLetter = String.fromCharCode(i);
        for (let j = 97; j < 97 + n; j++) {
            let secondLetter = String.fromCharCode(j);
            for (let k = 97; k < 97 + n; k++) {
                let thirdLetter = String.fromCharCode(k);
                console.log(`${firstLetter}${secondLetter}${thirdLetter}`);
            }
        }
    }
}
trippleLetters('3');