function countTheWords(input) {
    let message = input[0];
    let count = message.trim().split(/\s+/).length;

    if (count > 10) {
        console.log(`The message is too long to be send! Has ${count} words.`);
    } else {
        console.log(`The message was send successfully!`);
    }
}
