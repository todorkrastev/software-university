function sumSeconds(a, b, c) {
    let timeFirst = Number(a);
    let timeSecond = Number(b);
    let timeThird = Number(c);

    let totalTime = timeFirst + timeSecond + timeThird;

    let minutes = Math.floor(totalTime / 60);
    let seconds = totalTime % 60;

    if (seconds < 10) {
        console.log(`${minutes}:0${seconds}`);
    } else {
        console.log(`${minutes}:${seconds}`);
    }
}
