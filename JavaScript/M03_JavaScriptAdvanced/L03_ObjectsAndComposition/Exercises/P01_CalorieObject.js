function calorieObjects(arr) {
    let itemsCaloriesPer100gr = {};
    for (let index = 0; index < arr.length; index += 2) {
        const item = arr[index];
        const calories = Number(arr[index + 1]);
        itemsCaloriesPer100gr[item] = calories;
    }
    return itemsCaloriesPer100gr;

  /*  return arr.reduce((a, v, i) => {
        if (i % 2 === 0) {
            a[v] = Number(arr[i + 1]);
        }
        return a;
    }, {}); */
}
