class ChristmasDinner {
    constructor(budget) {
        this.budget = budget;
        this.dishes = [];
        this.products = [];
        this.guests = {};
    }

    get budget() {
        return this._budget;
    }

    set budget(value) {
        if (value < 0) {
            throw new Error('The budget cannot be a negative number');
        }

        this._budget = value;
    }

    shopping(product) {

        let [productType, productPrice] = product;

        if (this.budget < productPrice) {
            throw new Error('Not enough money to buy this product');
        }

        this.products.push(productType);
        this.budget -= productPrice;

        return `You have successfully bought ${productType}!`;
    }

    recipes(recipe) {
        let recipeName = recipe.recipeName;
        let productsList = recipe.productsList;

        productsList.forEach(l => {
            if (this.products.some(p => p === l) === false) {
                throw new Error('We do not have this product');
            }
        });

        this.dishes.push({
            recipeName,
            productsList
        });

        return `${recipeName} has been successfully cooked!`;
    }

    inviteGuests(name, dish) {
        if (this.dishes.some(d => d.recipeName === dish) === false) {
            throw new Error('We do not have this dish');
        }

        if (this.guests.hasOwnProperty(name)) {
            throw new Error('This guest has already been invited');
        }

        this.guests[name] = dish;

        return `You have successfully invited ${name}!`;
    }

    showAttendance() {
        let output = [];

        for (const [key, value] of Object.entries(this.guests)) {
            let guestName = key;
            let dish = value;

            let recipe = this.dishes.find(r => r.recipeName === dish).productsList;
            let products = recipe.join(', ');

            output.push(`${guestName} will eat ${dish}, which consists of ${products}`);
        }

        return output.join('\n');
    }
}
