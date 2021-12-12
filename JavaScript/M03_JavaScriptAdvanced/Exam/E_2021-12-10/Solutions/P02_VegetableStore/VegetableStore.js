class VegetableStore {
    constructor(owner, location) {
        this.owner = owner;
        this.location = location;
        this.availableProducts = [];
        this._totalPrice = 0;
    }

    loadingVegetables(vegetables) {
        vegetables.forEach(v => {
            let [type, quantity, price] = v.split(' ');
            quantity = Number(quantity);
            price = Number(price);

            if (this.availableProducts.some(v => v.type === type) === false) {
                let newVegie = {
                    type,
                    quantity,
                    price
                };

                this.availableProducts.push(newVegie);
            } else {
                let existingVegie = this.availableProducts.find(v => v.type === type);
                existingVegie.quantity += quantity;

                if (existingVegie.price < price) {
                    existingVegie.price = price;
                }
            }
        });

        let output = [];
        this.availableProducts.forEach(v => output.push(`${v.type}`));

        return `Successfully added ${output.join(', ')}`;
    }

    buyingVegetables(selectedProducts) {

        this._totalPrice = 0;
        selectedProducts.forEach(p => {
            let [type, quantity] = p.split(' ');
            quantity = Number(quantity);

            if (this.availableProducts.some(p => p.type === type) === false) {
                throw new Error(`${type} is not available in the store, your current bill is $${this._totalPrice.toFixed(2)}.`);
            }

            let vegie = this.availableProducts.find(v => v.type === type);

            if (vegie.quantity < quantity) {
                throw new Error(`The quantity ${quantity} for the vegetable ${type} is not available in the store, your current bill is $${this._totalPrice.toFixed(2)}.`);
            }

            let vegiePrice = vegie.price;
            let currPrice = vegiePrice * quantity;
            this._totalPrice += currPrice;
            vegie.quantity -= quantity;
        });

        return `Great choice! You must pay the following amount $${this._totalPrice.toFixed(2)}.`;
    }

    rottingVegetable(type, quantity) {

        if (this.availableProducts.some(p => p.type === type) === false) {
            throw new Error(`${type} is not available in the store.`);
        }

        let currVegie = this.availableProducts.find(v => v.type === type);

        if (currVegie.quantity < quantity) {
            currVegie.quantity = 0;

            return `The entire quantity of the ${type} has been removed.`;
        }

        currVegie.quantity -= quantity;

        return `Some quantity of the ${type} has been removed.`;
    }

    revision() {
        let output = [];

        output.push(`Available vegetables:`);
        this.availableProducts
            .sort((a, b) => a.price - b.price)
            .forEach(p => output.push(`${p.type}-${p.quantity}-$${p.price}`));
        output.push(`The owner of the store is ${this.owner}, and the location is ${this.location}.`);
        return output.join('\n');
    }
}


