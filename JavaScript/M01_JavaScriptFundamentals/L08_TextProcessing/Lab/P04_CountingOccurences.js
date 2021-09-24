function countStrOccurrences(str, word) {
    let occurences = 0;
    str.split(' ').map(w => w == word ? occurences++ : null);
    return occurences;
}
