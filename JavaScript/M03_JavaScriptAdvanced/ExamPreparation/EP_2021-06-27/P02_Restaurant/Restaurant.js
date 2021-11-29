class Restaurant {
    constructor(budgetMoney) {
        this.budgetMoney = budgetMoney;
        this.menu = {};
        this.stockProducts = {};
        this.history = [];
    }

    loadProducts(products) {
        for (const product of products) {
            let currName = product.split(' ')[0];
            let currQuantity = product.split(' ')[1];
            let currPrice = Number(product.split(' ')[2]);

            if (currQuantity * currPrice <= this.budgetMoney) {
                if()
                this.stockProducts[currName] = `${currName} ${currQuantity}`;

            }
        }
    }

    addToMenu(meal, products, price) {

    }

    showTheMenu() {

    }

    makeTheOrder(meal) {

    }
}

let kitchen = new Restaurant(1000);
console.log(kitchen.loadProducts(['Banana 10 5', 'Banana 20 10', 'Strawberries 50 30', 'Yogurt 10 10', 'Yogurt 500 1500', 'Honey 5 50']));

// Successfully loaded 10 Banana
// Successfully loaded 20 Banana
// Successfully loaded 50 Strawberries
// Successfully loaded 10 Yogurt
// There was not enough money to load 500 Yogurt
// Successfully loaded 5 Honey
