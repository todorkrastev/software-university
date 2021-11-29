class Restaurant {
    constructor(budget) {
        this.budgetMoney = budget;
        this.menu = {};
        this.stockProducts = {};
        this.history = [];
    }

    loadProducts(products) {
        for (const product of products) {
            let [productName, productQuantity, productPrice] = product.split(' ');
            productQuantity = Number(productQuantity);
            productPrice = Number(productPrice);

            if (productPrice <= this.budgetMoney) {
                if (this.stockProducts.hasOwnProperty(productName)) {
                    this.stockProducts[productName] += productQuantity;
                } else {
                    this.stockProducts[productName] = productQuantity;
                }
                this.budgetMoney -= productPrice;
                this.history.push(`Successfully loaded ${productQuantity} ${productName}`);
            } else {
                this.history.push(`There was not enough money to load ${productQuantity} ${productName}`);
            }
        }
        return this.history.join('\n');
    }

    addToMenu(meal, neededProducts, price) {
        if (this.menu.hasOwnProperty(meal)) {
            return `The ${meal} is already in the our menu, try something different.`;
        }
        this.menu[meal] = {
            neededProducts,
            price
        };
        if (Object.keys(this.menu).length == 1) {
            return `Great idea! Now with the ${meal} we have 1 meal in the menu, other ideas?`;
        } else {
            return `Great idea! Now with the ${meal} we have ${Object.keys(this.menu).length} meals in the menu, other ideas?`;
        }
    }

    showTheMenu() {
        if (Object.keys(this.menu).length == 0) {
            return `Our menu is not ready yet, please come later...`;
        }

        const output = [];
        for (const [meal, object] of Object.entries(this.menu)) {
            output.push(`${meal} - $ ${object.price}`);
        }

        return output.join('\n');
    }

    makeTheOrder(mealName) {
        if (this.menu.hasOwnProperty(mealName) == false) {
            return `There is not ${mealName} yet in our menu, do you want to order something else?`;
        }

        const meal = this.menu[mealName];

        for (const element of meal.neededProducts) {
            const [singleProduct, quantity] = element.split(' ');

            if (this.stockProducts.hasOwnProperty(singleProduct) == false || this.stockProducts[singleProduct] < quantity) {
                return `For the time being, we cannot complete your order (${mealName}), we are very sorry...`;
            }
        }

        for (const element of meal.neededProducts) {
            const [singleProduct, quantity] = element.split(' ');

            this.stockProducts[singleProduct] -= quantity;
            this.budgetMoney += meal.price;
        }

        return `Your order (${mealName}) will be completed in the next 30 minutes and will cost you ${meal.price}.`;
    }
}
