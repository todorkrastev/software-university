function minNum(input) {
    let i = 0, inp = '', numArr = [];
    while (inp != "Stop") {
        inp = input[i];
        i++;
        if (inp == "Stop") {
            console.log(Math.min(...numArr));
        }
        numArr.push(inp);
    }
}
