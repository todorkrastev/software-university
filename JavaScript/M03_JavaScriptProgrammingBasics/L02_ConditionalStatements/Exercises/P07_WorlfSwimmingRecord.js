function wordSwimmingRecord(a, b, c) {
    let recordInSeconds = Number(a);
    let distanceInMeters = Number(b);
    let timeInSecondsOneMeter = Number(c);

    let mustSwim = distanceInMeters * timeInSecondsOneMeter
    let addingMeters = Math.floor(distanceInMeters / 15)
    let addingTime = addingMeters * 12.5
    let total = mustSwim + addingTime

    if (recordInSeconds <= total) {
        console.log(`No, he failed! He was ${(total - recordInSeconds).toFixed(2)} seconds slower.`)

    } else {
        console.log(`Yes, he succeeded! The new world record is ${(total).toFixed(2)} seconds.`)
    }
}
