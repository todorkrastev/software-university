function wordOccurences(arr) {
    let timesOccuring = [];

    arr.forEach(word => {
        if (!timesOccuring.hasOwnProperty(word)) {
            timesOccuring[word] = 1;
        } else {
            timesOccuring[word] += 1;
        }
    })

    let sortedDescending = Object.keys(timesOccuring).sort(function (a, b) {
        return timesOccuring[b] - timesOccuring[a];
    })

    sortedDescending.forEach(word => {
        console.log(`${word} -> ${timesOccuring[word]} times`)
    });
}
