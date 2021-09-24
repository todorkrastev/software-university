function foo(arr) {
    const sorted = arr.sort((a, b) => a - b).slice(0, 2);
    return sorted.join(' ');
}
