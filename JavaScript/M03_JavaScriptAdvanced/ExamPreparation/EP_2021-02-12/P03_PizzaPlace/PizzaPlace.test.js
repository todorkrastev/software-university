const pizzUni = require('./PizzaPlace');
const { expect } = require('chai');
const { makeAnOrder } = require('./PizzaPlace');

describe('Testing Pizza Uni Functionality', () => {
    describe('Testing Make Order Functionality', () => {
        it('throws an error when an empty string is passed', () => {
            // expect(pizzUni.makeAnOrder.bind(makeAnOrder, { orderedPizza: '', orderedDrink: '' })).to.throw('You must order at least 1 Pizza to finish the order.');
            // expect(pizzUni.makeAnOrder.bind(makeAnOrder, { orderedPizza: '', orderedDrink: 'Orange Juice' })).to.throw('You must order at least 1 Pizza to finish the order.');
            // expect(pizzUni.makeAnOrder.bind(makeAnOrder, { orderedPizza: null, orderedDrink: null })).to.throw('You must order at least 1 Pizza to finish the order.');
            // expect(pizzUni.makeAnOrder.bind(makeAnOrder, { orderedPizza: null, orderedDrink: 'Milk' })).to.throw('You must order at least 1 Pizza to finish the order.');

            expect(() => pizzUni.makeAnOrder({ orderedPizza: null, orderedDrink: null })).to.throw('You must order at least 1 Pizza to finish the order.');
            expect(() => pizzUni.makeAnOrder({ orderedPizza: '', orderedDrink: '' })).to.throw('You must order at least 1 Pizza to finish the order.');
        });

        it('returns a string with ordered products', () => {
            expect(pizzUni.makeAnOrder({ orderedPizza: 'Diavola', orderedDrink: 'Orange Juice' })).to.equal('You just ordered Diavola and Orange Juice.');
            expect(pizzUni.makeAnOrder({ orderedPizza: 'Diavola', orderedDrink: '' })).to.equal('You just ordered Diavola');
            expect(pizzUni.makeAnOrder({ orderedPizza: 'Diavola', orderedDrink: '2' })).to.equal('You just ordered Diavola and 2.');
            expect(pizzUni.makeAnOrder({ orderedPizza: '1', orderedDrink: 'Orange Juice' })).to.equal('You just ordered 1 and Orange Juice.');
            expect(pizzUni.makeAnOrder({ orderedPizza: 1, orderedDrink: 2 })).to.equal('You just ordered 1 and 2.');
            expect(pizzUni.makeAnOrder({ orderedPizza: 1, orderedDrink: null })).to.equal('You just ordered 1');

        });
    });

    describe('Testing Get Remaining Work Functionality', () => {
        it('returns a string with a message "All orders are completed!"', () => {
            expect(pizzUni.getRemainingWork([{ pizzaName: 'Salami', status: 'ready' }])).to.equal('All orders are complete!');
            expect(pizzUni.getRemainingWork([{ pizzaName: 'Salami', status: 'ready' }, { pizzaName: 'Margharita', status: 'ready' }])).to.equal('All orders are complete!');
            expect(pizzUni.getRemainingWork([{ pizzaName: 'Salami', status: 'in proccess' }])).to.equal('The following pizzas are still preparing: Salami.');
            expect(pizzUni.getRemainingWork([{ pizzaName: 'Salami', status: '' }])).to.equal('The following pizzas are still preparing: Salami.');
            expect(pizzUni.getRemainingWork([{ pizzaName: 'Salami', status: null }])).to.equal('The following pizzas are still preparing: Salami.');
            expect(pizzUni.getRemainingWork([{ pizzaName: 'Salami', status: undefined }])).to.equal('The following pizzas are still preparing: Salami.');
            expect(pizzUni.getRemainingWork([{ pizzaName: 'Salami', status: '' }, { pizzaName: 'Margharita', status: '' }])).to.equal('The following pizzas are still preparing: Salami, Margharita.');
            expect(pizzUni.getRemainingWork([{ pizzaName: 'Salami', status: undefined }, { pizzaName: 'Margharita', status: undefined }])).to.equal('The following pizzas are still preparing: Salami, Margharita.');
        });

        it('returns a string with a message "The following pizzas are still preparing: pizza1, pizza2, ..."', () => {
            expect(pizzUni.getRemainingWork([{ pizzaName: 'Salami', status: 'in proccess' }])).to.equal('The following pizzas are still preparing: Salami.');
            expect(pizzUni.getRemainingWork([{ pizzaName: 'Salami', status: '' }])).to.equal('The following pizzas are still preparing: Salami.');
            expect(pizzUni.getRemainingWork([{ pizzaName: 'Salami', status: null }])).to.equal('The following pizzas are still preparing: Salami.');
            expect(pizzUni.getRemainingWork([{ pizzaName: 'Salami', status: undefined }])).to.equal('The following pizzas are still preparing: Salami.');
            expect(pizzUni.getRemainingWork([{ pizzaName: 'Salami', status: '' }, { pizzaName: 'Margharita', status: '' }])).to.equal('The following pizzas are still preparing: Salami, Margharita.');
            expect(pizzUni.getRemainingWork([{ pizzaName: 'Salami', status: undefined }, { pizzaName: 'Margharita', status: undefined }])).to.equal('The following pizzas are still preparing: Salami, Margharita.');
        });
    });

    describe('Testing Order Type Functionality', () => {
        it('returns the total sum with 10 % discount when "Carry out" as a parameter is passed', () => {
            expect(pizzUni.orderType(12.95, 'Carry Out')).to.equal(11.655);
            expect(pizzUni.orderType(0, 'Carry Out')).to.equal(0);
            expect(pizzUni.orderType(-5, 'Carry Out')).to.equal(-4.5);
            expect(pizzUni.orderType(-5.6, 'Carry Out')).to.equal(-5.04);
        });

        it('returns the total sum when "Delivery" as a parameter is passed', () => {
            expect(pizzUni.orderType(12.95, 'Delivery')).to.equal(12.95);
            expect(pizzUni.orderType(0, 'Delivery')).to.equal(0);
            expect(pizzUni.orderType(-5, 'Delivery')).to.equal(-5);
            expect(pizzUni.orderType(-5.6, 'Delivery')).to.equal(-5.6);
        });

        it('returns undefined when a parameter other than "Delivery" or "Carry Out" is passed', () => {
            expect(pizzUni.orderType(12.95, '')).to.be.undefined;
            expect(pizzUni.orderType(0, null)).to.be.undefined;
            expect(pizzUni.orderType(-5, 'Out of service')).to.be.undefined;
            expect(pizzUni.orderType(-5.6, 'Closed')).to.be.undefined;
            expect(pizzUni.orderType(-5.6, undefined)).to.be.undefined;
        });
    });
});