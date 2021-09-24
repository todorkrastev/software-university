function solve(inputAge) {
    if (0 <= inputAge && inputAge <= 2) {
        console.log("baby");
    } else if (3 <= inputAge && inputAge <= 13) {
        console.log("child");
    } else if (14 <= inputAge && inputAge <= 19) {
        console.log("teenager");
    } else if (20 <= inputAge && inputAge <= 65) {
        console.log("adult");
    } else if (66 <= inputAge) {
        console.log("elder");
    } else {
        console.log("out of bounds");
    }
}
