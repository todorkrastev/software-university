function oldBooks(input) {
    let faveBook = input[0];

    let inp = '', index = 1;
    while (inp != "No More Books") {
        let inp = input[index];
        if (inp == faveBook) {
            console.log(`You checked ${index - 1} books and found it.`);
            break;
        }
        else if (inp == "No More Books") {
            console.log(`The book you search is not here!` + '\n' +
                `You checked ${index - 1} books.`);
            break;
        }
        index++;
    }
}
