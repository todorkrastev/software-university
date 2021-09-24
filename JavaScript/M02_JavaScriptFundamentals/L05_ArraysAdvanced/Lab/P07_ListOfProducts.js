function foo(arr) {
    let sorted = arr.sort();
    let list = [], item = '';

    for (let i = 0; i < sorted.length; i++) {
        item = sorted[i];
        list.push(`${i + 1}.${item}`);
    }
    return list.join('\n');
}
