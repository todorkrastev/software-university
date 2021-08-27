function Pyramid(base, increment) {

    let totalstone = 0;
    let totalmarble = 0;
    let totallapis = 0;
    let totalgold = 0;
    let row = 0;
    let currentbase = base;

    while (currentbase > 2) {
        let marbel = currentbase * 4 - 4;
        let stone = currentbase * currentbase - marbel;
        totalstone += stone;

        row++;
        if (row % 5 === 0) {
            totallapis += marbel;
        } else {
            totalmarble += marbel;
        }
        currentbase -= 2;
    }
    row++;
    let gold = currentbase * currentbase;

    stone = Math.ceil(totalstone * increment);
    marble = Math.ceil(totalmarble * increment);
    lapis = Math.ceil(totallapis * increment);
    totalgold = Math.ceil(gold * increment);
    totalHeight = Math.floor(row * increment);

    console.log(`Stone required: ${stone}`);
    console.log(`Marble required: ${marble}`);
    console.log(`Lapis Lazuli required: ${lapis}`);
    console.log(`Gold required: ${totalgold}`);
    console.log(`Final pyramid height: ${totalHeight}`);
}
