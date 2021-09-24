function readText(input) {
    let i = 0, text = '';
    while (text != "Stop") {
        text = input[i];
        i++;
        if (text == "Stop") { } else {
            console.log(text);
        }
    }
}
