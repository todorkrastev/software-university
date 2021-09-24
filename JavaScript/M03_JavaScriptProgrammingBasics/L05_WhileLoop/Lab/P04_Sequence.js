function sequence(input) {
    let initNum = Number(input[0]);
    let num = 1, count = 1, arr = [num];
    while (count < initNum) {
        num = (num * 2) + 1;
        arr.push(num);
        count += num;
    }
    console.log(arr.join('\n'));
}
