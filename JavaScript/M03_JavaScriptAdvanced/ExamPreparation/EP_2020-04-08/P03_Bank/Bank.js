class Bank {
    constructor(bankName) {
        this._bankName = bankName;
        this.allCustomers = [];
    }

    newCustomer({ firstName, lastName, personalId }) {

        if (this.allCustomers.some(c => c.personalId === personalId) === true) {
            throw new Error(`${firstName} ${lastName} is already our customer!`);
        }

        let currCustomer = {
            firstName,
            lastName,
            personalId
        };
        this.allCustomers.push(currCustomer);

        return currCustomer;
    }

    depositMoney(personalId, amount) {
        if (this.allCustomers.some(c => c.personalId === personalId) === false) {
            throw new Error(`We have no customer with this ID!`);
        }

        let customer = this.allCustomers.find(c => c.personalId === personalId);

        if (customer.totalMoney === undefined) {
            customer.totalMoney = 0;
            customer.transactions = [];
        }
        customer.totalMoney += amount;
        customer.transactions.push(`${customer.transactions.length + 1}. ${customer.firstName} ${customer.lastName} made deposit of ${amount}$!`);

        return `${customer.totalMoney}$`;
    }

    withdrawMoney(personalId, amount) {
        if (this.allCustomers.some(c => c.personalId === personalId) === false) {
            throw new Error(`We have no customer with this ID!`);
        }

        let customer = this.allCustomers.find(c => c.personalId === personalId);
        if (customer.totalMoney < amount) {
            throw new Error(`${customer.firstName} ${customer.lastName} does not have enough money to withdraw that amount!`);
        }

        customer.totalMoney -= amount;
        customer.transactions.push(`${customer.transactions.length + 1}. ${customer.firstName} ${customer.lastName} withdrew ${amount}$!`);

        return `${customer.totalMoney}$`;
    }

    customerInfo(personalId) {
        if (this.allCustomers.some(c => c.personalId === personalId) === false) {
            throw new Error(`We have no customer with this ID!`);
        }


        let customer = this.allCustomers.find(c => c.personalId === personalId);
        let output = [];

        output.push(`Bank name: ${this._bankName}`);
        output.push(`Customer name: ${customer.firstName} ${customer.lastName}`);
        output.push(`Customer ID: ${customer.personalId}`);
        output.push(`Total Money: ${customer.totalMoney}$`);
        output.push(`Transactions:`);

        this.allCustomers
            .filter(c => c.personalId === personalId)
            .forEach(c =>
                c.transactions.sort((a, b) => b.localeCompare(a))
                    .forEach(t => output.push(t)));

        return output.join('\n');
    }
}
