function closure() {
    const recipes = {
        apple: { protein: 0, carbohydrate: 1, fat: 0, flavour: 2 },
        lemonade: { protein: 0, carbohydrate: 10, fat: 0, flavour: 20 },
        burger: { protein: 0, carbohydrate: 5, fat: 7, flavour: 3 },
        eggs: { protein: 5, carbohydrate: 0, fat: 1, flavour: 1 },
        turkey: { protein: 10, carbohydrate: 10, fat: 10, flavour: 10 }
    };

    const storage = {
        carbohydrate: 0,
        flavour: 0,
        fat: 0,
        protein: 0
    };

    function restock(element, quantity) {
        storage[element] += quantity;
        return `Success`;
    }

    function prepare(recipe, quantity) {
        const remainingStorage = {};

        for (const element in recipes[recipe]) {
            const remaining = storage[element] - recipes[recipe][element] * quantity;
            if (remaining < 0) {
                return `Error: not enough ${element} in stock`;
            } else {
                remainingStorage[element] = remaining;
            }
        }

        Object.assign(storage, remainingStorage);
        return `Success`;
    }

    function report() {
        return `protein=${storage.protein} carbohydrate=${storage.carbohydrate} fat=${storage.fat} flavour=${storage.flavour}`;
    }

    function control(str) {
        const [command, item, quantity] = str.split(' ');

        switch (command) {
            case 'restock':
                return restock(item, Number(quantity));
            case 'prepare':
                return prepare(item, Number(quantity));
            case 'report':
                return report();
        }
    }

    return control;



    // second option


    // const ingreds = {
    //     protein: 0,
    //     carbohydrate: 0,
    //     fat: 0,
    //     flavour: 0,
    // };
    // const recipes = {
    //     apple: parseRecipeData(0, 1, 0, 2),
    //     lemonade: parseRecipeData(0, 10, 0, 20),
    //     burger: parseRecipeData(0, 5, 7, 3),
    //     eggs: parseRecipeData(5, 0, 1, 1),
    //     turkey: parseRecipeData(10, 10, 10, 10),
    // };

    // function parseRecipeData(protein, carbohydrate, fat, flavour) {
    //     return {
    //         protein,
    //         carbohydrate,
    //         fat,
    //         flavour,
    //     }
    // }

    // function restock(ingr, x) {
    //     ingreds[ingr] += x;
    //     return 'Success';
    // }

    // function prepare(required, quantity) {
    //     const parsedRecipe = Object.entries(required).map(x => [
    //         x[0],
    //         x[1] * quantity,
    //     ])

    //     for (let i = 0; i < parsedRecipe.length; i++) {
    //         const [name, amount] = parsedRecipe[i];
    //         if (ingreds[name] - amount < 0) {
    //             return `Error: not enough ${name} in stock`;
    //         }
    //     }

    //     parsedRecipe.forEach(([name, amount]) => (ingreds[name] -= amount));
    //     return 'Success';
    // }

    // const report = () =>
    //     Object.entries(ingreds)
    //         .map(([key, value]) => `${key}=${value}`)
    //         .join(' ');

    // const actions = {
    //     prepare: (r, q) => prepare(recipes[r], q),
    //     restock,
    //     report,
    // };

    // return s => {
    //     const [command, a, b] = s
    //         .split(' ')
    //         .map(x => (isNaN(x) ? x : Number(x)));

    //     return actions[command](a, b);
    // }
}
