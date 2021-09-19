function moving(input) {
    let width = parseInt(input[0]);
    let height = parseInt(input[1]);
    let length = parseInt(input[2]);
    const freeSpace = width * height * length;

    let index = 3, boxes = '', spaceTaken = 0, spaceLeft = 0;
    while (boxes != "Done") {
        boxes = input[index];
        index++;
        spaceLeft = freeSpace - spaceTaken;

        if (boxes == "Done") {
            console.log(`${spaceLeft} Cubic meters left.`);
            break;
        } else if (spaceLeft < boxes) {
            console.log(`No more free space! You need ${boxes - spaceLeft} Cubic meters more.`);
            break;
        }
        spaceTaken += parseInt(boxes);
    }
}
