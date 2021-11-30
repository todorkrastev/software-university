const numberOperations = require('./NumberOperations');
const {expect} = require('chai');

describe('Testing Number Operations', () => {
    describe('Testing Power Number Functionality', () => {
        it('Returns the power of two numbers', () => {
            expect(numberOperations.powNumber(1)).to.equal(1);
            expect(numberOperations.powNumber(0)).to.equal(0);
            expect(numberOperations.powNumber(1594)).to.equal(2540836);
            expect(numberOperations.powNumber(-1594)).to.equal(2540836);
            expect(numberOperations.powNumber(-2)).to.equal(4);
            expect(numberOperations.powNumber(-2.5)).to.equal(6.25);
            expect(numberOperations.powNumber(-21.5545)).to.equal(464.59647025000004);
            expect(numberOperations.powNumber(5.55)).to.equal(30.8025);
        });
    });

    describe('Testing Number Checker Functionality', () => {
        it('throws an error if an invalid input is passed', () => {
            expect(numberOperations.numberChecker.bind('')).to.throw('The input is not a number!');
            expect(numberOperations.numberChecker.bind(null)).to.throw('The input is not a number!');
            expect(numberOperations.numberChecker.bind('abc')).to.throw('The input is not a number!');
            expect(numberOperations.numberChecker.bind(undefined)).to.throw('The input is not a number!');
            expect(numberOperations.numberChecker.bind(true)).to.throw('The input is not a number!');
            expect(numberOperations.numberChecker.bind(false)).to.throw('The input is not a number!');
        });

        it('if input number is less than 100, returns a message "The number is lower than 100!"', () => {
            expect(numberOperations.numberChecker(99)).to.equal('The number is lower than 100!');
            expect(numberOperations.numberChecker(44.4)).to.equal('The number is lower than 100!');
            expect(numberOperations.numberChecker(0)).to.equal('The number is lower than 100!');
            expect(numberOperations.numberChecker(-22)).to.equal('The number is lower than 100!');
            expect(numberOperations.numberChecker(-555.21)).to.equal('The number is lower than 100!');
            expect(numberOperations.numberChecker('-555.21')).to.equal('The number is lower than 100!');
        });

        it('if number is equal or more than 100, returns a message "The number is greater or equal to 100!"', () => {
            expect(numberOperations.numberChecker(100)).to.equal('The number is greater or equal to 100!');
            expect(numberOperations.numberChecker(145.2434)).to.equal('The number is greater or equal to 100!');
            expect(numberOperations.numberChecker(2124324.2434)).to.equal('The number is greater or equal to 100!');
            expect(numberOperations.numberChecker('100')).to.equal('The number is greater or equal to 100!');
        })
    });

    describe('Testing Sum Array Functionality', () => {
        it('return the sum of 2 arrays', () => {
            expect(numberOperations.sumArrays([1, 2, 3], [1, 2, 3])).to.deep.equal([2, 4, 6]);
        })

        it('return the sum of 2 arrays', () => {
            expect(numberOperations.sumArrays([1, 2, 3], [4, 5, 6])).to.deep.equal([5, 7, 9]);
        })

        it('return the sum of 2 arrays', () => {
            expect(numberOperations.sumArrays([-1, -2, -3], [-4, -5, -6])).to.deep.equal([-5, -7, -9]);
        })

        it('return the sum of 2 arrays', () => {
            expect(numberOperations.sumArrays([1.2, 2.3, 3.4], [4.5, 5.6, 6.7])).to.deep.equal([5.7, 7.8999999999999995, 10.1]);
        })

        it('return the sum of 2 arrays', () => {
            expect(numberOperations.sumArrays([-1.2, -2.3, -3.4], [-4.5, -5.6, -6.7])).to.deep.equal([-5.7, -7.8999999999999995, -10.1]);
        })

        it('return the sum of 2 arrays', () => {
            expect(numberOperations.sumArrays([1], [1, 2, 3])).to.deep.equal([2, 2, 3]);
        })

        it('return the sum of 2 arrays', () => {
            expect(numberOperations.sumArrays([1, 2, 3], [1])).to.deep.equal([2, 2, 3]);
        })

        it('return the sum of 2 arrays', () => {
            expect(numberOperations.sumArrays([1, 2, 3], [])).to.deep.equal([1, 2, 3]);
        })

        it('return the sum of 2 arrays', () => {
            expect(numberOperations.sumArrays([], [1, 2, 3])).to.deep.equal([1, 2, 3]);
        })
    });
});


// refactoring

/*
describe('Test Number Operations', () => {

    describe('Test Pow Number Func', () => {
        it('Returns the power of the input', () => {
            expect(numberOperations.powNumber(-5)).to.equal(25);
            expect(numberOperations.powNumber(5)).to.equal(25);
            expect(numberOperations.powNumber(5.5)).to.equal(30.25);
            expect(numberOperations.powNumber(-5.5)).to.equal(30.25);
            expect(numberOperations.powNumber(0)).to.equal(0);
        });
    });

    describe('Test Number Checker Func', () => {

        it('Throws an error if the input is NaN', () => {
            expect(() => numberOperations.numberChecker('str')).to.throw('The input is not a number!');
            expect(() => numberOperations.numberChecker(undefined)).to.throw('The input is not a number!');
            expect(() => numberOperations.numberChecker()).to.throw('The input is not a number!');
            expect(() => numberOperations.numberChecker({})).to.throw('The input is not a number!');
            expect(() => numberOperations.numberChecker(NaN)).to.throw('The input is not a number!');
        });

        it('Returns a message "The number is lower than 100!"', () => {
            expect(numberOperations.numberChecker(99)).to.equal('The number is lower than 100!');
            expect(numberOperations.numberChecker(99.9)).to.equal('The number is lower than 100!');
        });

        it('Returns a message "The number is greater or equal to 100!"', () => {
            expect(numberOperations.numberChecker(100)).to.equal('The number is greater or equal to 100!');
            expect(numberOperations.numberChecker(100.1)).to.equal('The number is greater or equal to 100!');
        });
    });

    describe('Test Sum Array Func', () => {

        it('Returns the sum of 2 arrays', () => {
            expect(numberOperations.sumArrays([1], [])).to.deep.equal([1]);
            expect(numberOperations.sumArrays([1], [1, 2])).to.deep.equal([2, 2]);
        });
    });
});
 */
