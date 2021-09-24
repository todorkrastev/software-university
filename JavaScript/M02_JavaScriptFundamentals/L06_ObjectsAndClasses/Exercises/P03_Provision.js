function foo(arr, arr1) {
    isNumber = n => !isNaN(Number(n));
    const result = arr
        .concat(arr1)
        .map(x => (isNumber(x) ? Number(x) : x))
        .reduce((a, v, i, target) => {
            if (typeof v !== "number" && v !== undefined) a[v] = (a[v] || 0) + target[i + 1] || ''
            return a
        }, {});

    Object.entries(result).forEach(x => console.log(`${x[0]} -> ${x[1]}`));
}
