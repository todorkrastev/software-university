function cake(input) {
    let index = 0;
    let width = parseInt(input[index++]);
    let height = parseInt(input[index++]);
    let pieces = width * height;

    let inp = '';
    while (inp != "STOP") {
        inp = input[index++];
        if (inp == "STOP") {
            console.log(`${pieces} pieces are left.`);
            break;
        }
        if (inp >= pieces) {
            console.log(`No more cake left! You need ${inp - pieces} pieces more.`);
            break;
        }
        pieces -= inp;
    }
}
