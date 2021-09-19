function speedInfo(a) {
    let num = Number(a);

    if (num <= 10) {
        console.log("slow");
    } else if (num > 10 && num <= 50) {
        console.log("average");
    } else if (num > 50 && num <= 150) {
        console.log("fast");
    } else if (num > 150 && num <= 1000) {
        console.log("ultra fast");
    } else {
        console.log("extremely fast");
    }
}
