function reverseAnArrayOfStrings(input) {
    let save = "";

    for (let i = input.length - 1; i >= 0; i--) {
        save += input[i] + " ";
    }
    console.log(save);
}
