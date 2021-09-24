function matchPhoneNumber(arr) {
    let re = /(\+359)([-\s])2\2\d{3}\2\d{4}/g;
    let validNumbers = arr.shift().match(re);
    return validNumbers !== null ? validNumbers.join(', ') : '';
}
