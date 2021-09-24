function reverseAnArrayOfNumbers(num, arr) {
    let numbers = Number(num);
    let array = arr
    let save = "";

    for (let i = numbers - 1; i >= 0; i--) {
        save += array[i] + " ";
    }
    console.log(save);
}
