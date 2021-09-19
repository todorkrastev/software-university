function characterSequence(input) {
    let text = input[0];

    let value = {
        a: 1,
        e: 2,
        i: 3,
        o: 4,
        u: 5
    }

    let sum = 0;
    for (let i = 0; i < text.length; i++) {
        if (value[text[i]]) {
            sum += value[text[i]];
        }
    }
    console.log(sum);
}
