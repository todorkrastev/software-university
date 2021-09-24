function numsPyramid(input) {
    let n = input[0], current = 1, isBigger = false;
    for (let rows = 1; rows <= n; rows++) {
        let currentLine = ``;

        for (let cols = 1; cols <= rows; cols++) {
            if (current > n) {
                isBigger = true;
                break;
            }
            currentLine += current + ` `;
            current++;
        }
        console.log(currentLine);
        if (isBigger) {
            break;
        }
    }
}
