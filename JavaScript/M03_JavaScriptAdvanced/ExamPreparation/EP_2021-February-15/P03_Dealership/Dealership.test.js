const dealership = require('./Dealership');
const { expect } = require('chai');

describe('Testing Dealership Functionality', () => {
    describe('Testing New Car Cost Functionality', () => {
        it('checking if the customer is returning the old car to the dealer or not', () => {
            expect(dealership.newCarCost('Audi', 150000)).to.equal(150000);
            expect(dealership.newCarCost('Audi A4', 150000)).to.equal(150000);
            expect(dealership.newCarCost('Audi A4 B8', 150000)).to.equal(135000);
        });
    });

    describe('Testing Car Equipment Functionality', () => {
        it('checking if the customer is returning the old car to the dealer or not', () => {
            expect(dealership.carEquipment(['automatic transmission', 'electric motor', 'leather interior', 'trasnsperent roof'], [0, 1, 2, 3])).to.deep.equal(['automatic transmission', 'electric motor', 'leather interior', 'trasnsperent roof']);
            expect(dealership.carEquipment(['automatic transmission', 'electric motor', 'leather interior', 'trasnsperent roof'], [1, 2])).to.deep.equal(['electric motor', 'leather interior']);
            expect(dealership.carEquipment(['automatic transmission', 'electric motor', 'leather interior', 'trasnsperent roof'], [3])).to.deep.equal(['trasnsperent roof']);
            expect(dealership.carEquipment(['automatic transmission', 'electric motor', 'leather interior', 'trasnsperent roof'], [0])).to.deep.equal(['automatic transmission']);
        });
    });

    describe('Testing Euro Category Functionality', () => {
        it('should return the final price with 5 % discout', () => {
            expect(dealership.euroCategory(4)).to.equal('We have added 5% discount to the final price: 14250.');
            expect(dealership.euroCategory(5)).to.equal('We have added 5% discount to the final price: 14250.');
            expect(dealership.euroCategory(23)).to.equal('We have added 5% discount to the final price: 14250.');
        });

        it('should return the final price with 5 % discout', () => {
            expect(dealership.euroCategory(3)).to.equal('Your euro category is low, so there is no discount from the final price!');
            expect(dealership.euroCategory(2)).to.equal('Your euro category is low, so there is no discount from the final price!');
            expect(dealership.euroCategory(1)).to.equal('Your euro category is low, so there is no discount from the final price!');
            expect(dealership.euroCategory(0)).to.equal('Your euro category is low, so there is no discount from the final price!');
            expect(dealership.euroCategory(-1)).to.equal('Your euro category is low, so there is no discount from the final price!');
        });
    });
});
