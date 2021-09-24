function matchFullName(input) {
    let re = /(\b[A-Z]{1})([a-z]+)( {1})([A-Z]{1})([a-z]+)/g;
    let validNames = input.shift().match(re);
    return validNames !== null ? validNames.join(' ') : '';
}
