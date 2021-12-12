const companyAdministration = require('./companyAdministration');
const { expect } = require('chai');

describe('Testing companyAdministration Func', () => {

    describe('Testing hiringEmployee Func', () => {
        it('If position is not a Programmer, throws an error', () => {
            expect(() => companyAdministration.hiringEmployee()).to.throw('We are not looking for workers for this position.');
            expect(() => companyAdministration.hiringEmployee('name', null, 3)).to.throw('We are not looking for workers for this position.');
            expect(() => companyAdministration.hiringEmployee('name', undefined, 3)).to.throw('We are not looking for workers for this position.');
            expect(() => companyAdministration.hiringEmployee('name', [], 3)).to.throw('We are not looking for workers for this position.');
            expect(() => companyAdministration.hiringEmployee('name', {}, 3)).to.throw('We are not looking for workers for this position.');
            expect(() => companyAdministration.hiringEmployee('name', isNaN, 3)).to.throw('We are not looking for workers for this position.');
            expect(() => companyAdministration.hiringEmployee('name', '', 3)).to.throw('We are not looking for workers for this position.');
            expect(() => companyAdministration.hiringEmployee('name', 'string', 3)).to.throw('We are not looking for workers for this position.');
            expect(() => companyAdministration.hiringEmployee('name', 4, 3)).to.throw('We are not looking for workers for this position.');
        });

        it('If position is a Programmer and the experience is equal to or more than 3 years, returns a successful message', () => {
            expect(companyAdministration.hiringEmployee('name', 'Programmer', 3)).to.equal('name was successfully hired for the position Programmer.')
        });

        it('If position is a Programmer and the experience is less than 3, returns unsuccessful message', () => {
            expect(companyAdministration.hiringEmployee('name', 'Programmer', 2)).to.equal('name is not approved for this position.');
        });
    });

    describe('Testing calculateSalary Func', () => {

        it('If type of hours is NOT a number or hours is less than 0, throws an error', () => {
            expect(() => companyAdministration.calculateSalary()).to.throw('Invalid hours');
            expect(() => companyAdministration.calculateSalary(undefined)).to.throw('Invalid hours');
            expect(() => companyAdministration.calculateSalary(null)).to.throw('Invalid hours');
            expect(() => companyAdministration.calculateSalary({})).to.throw('Invalid hours');
            expect(() => companyAdministration.calculateSalary([])).to.throw('Invalid hours');
            expect(() => companyAdministration.calculateSalary('')).to.throw('Invalid hours');
            expect(() => companyAdministration.calculateSalary(isNaN)).to.throw('Invalid hours');
            expect(() => companyAdministration.calculateSalary('string')).to.throw('Invalid hours');
            expect(() => companyAdministration.calculateSalary(-1)).to.throw('Invalid hours');
            expect(() => companyAdministration.calculateSalary(-1.1)).to.throw('Invalid hours');
        });

        it('If hours are more than 160 returns totalAmo + 1000', () => {
            expect(companyAdministration.calculateSalary(161)).to.equal(3415);
            expect(companyAdministration.calculateSalary(200.5)).to.equal(4007.5);
        });

        it('If hours are between 0 and 160, returns totalAmo', () => {
            expect(companyAdministration.calculateSalary(0)).to.equal(0);
            expect(companyAdministration.calculateSalary(160)).to.equal(2400);
            expect(companyAdministration.calculateSalary(1.1)).to.equal(16.5);
        });
    });

    describe('Testing firedEmployee Func', () => {

        it('If the input is NOT a valid array or index is NOT an integer or index is less than 0, or index is equal to or more than the array.length, throws an error', () => {
            expect(() => companyAdministration.firedEmployee()).to.throw('Invalid input');
            expect(() => companyAdministration.firedEmployee({}, 1)).to.throw('Invalid input');
            expect(() => companyAdministration.firedEmployee([{}], 1)).to.throw('Invalid input');
            expect(() => companyAdministration.firedEmployee([{foo: 123}], 1)).to.throw('Invalid input');
            expect(() => companyAdministration.firedEmployee('string', 1)).to.throw('Invalid input');
            expect(() => companyAdministration.firedEmployee(undefined, 1)).to.throw('Invalid input');
            expect(() => companyAdministration.firedEmployee(null, 1)).to.throw('Invalid input');
            expect(() => companyAdministration.firedEmployee([], 1)).to.throw('Invalid input');
            expect(() => companyAdministration.firedEmployee(1, 1)).to.throw('Invalid input');
            expect(() => companyAdministration.firedEmployee(isNaN, 1)).to.throw('Invalid input');

            expect(() => companyAdministration.firedEmployee(['Ant', 'Bear', 'Cat'], 1.1)).to.throw('Invalid input');
            expect(() => companyAdministration.firedEmployee(['Ant', 'Bear', 'Cat'], '')).to.throw('Invalid input');
            expect(() => companyAdministration.firedEmployee(['Ant', 'Bear', 'Cat'])).to.throw('Invalid input');
            expect(() => companyAdministration.firedEmployee(['Ant', 'Bear', 'Cat'], undefined)).to.throw('Invalid input');
            expect(() => companyAdministration.firedEmployee(['Ant', 'Bear', 'Cat'], null)).to.throw('Invalid input');
            expect(() => companyAdministration.firedEmployee(['Ant', 'Bear', 'Cat'], {})).to.throw('Invalid input');
            expect(() => companyAdministration.firedEmployee(['Ant', 'Bear', 'Cat'], [])).to.throw('Invalid input');
            expect(() => companyAdministration.firedEmployee(['Ant', 'Bear', 'Cat'], isNaN)).to.throw('Invalid input');
            expect(() => companyAdministration.firedEmployee(['Ant', 'Bear', 'Cat'], 'string')).to.throw('Invalid input');

            expect(() => companyAdministration.firedEmployee(['Ant', 'Bear', 'Cat'], -1)).to.throw('Invalid input');
            expect(() => companyAdministration.firedEmployee(['Ant', 'Bear', 'Cat'], 3)).to.throw('Invalid input');
        });

        it('Returns the current employees joined with commma', () => {
            expect(companyAdministration.firedEmployee(['Ant', 'Bear', 'Cat', 'Dog', 'Elephant'], 3)).to.equal('Ant, Bear, Cat, Elephant');
            expect(companyAdministration.firedEmployee(['Ant'], 0)).to.equal('');
        });
    });
});

/*

module.exports = name of an object

const name of an object = require('./name of a file');
const { expect } = require('chai');

describe('', () => {

});

it('', () => {

});

 */







