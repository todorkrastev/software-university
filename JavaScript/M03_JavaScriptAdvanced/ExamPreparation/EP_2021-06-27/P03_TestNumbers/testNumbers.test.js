const testNumbers = require('./testNumbers');
const { numberChecker } = require('./testNumbers');
const { expect } = require('chai');


describe('Testing Numbers Functionality', () => {
    describe('Testing Sum Functionality', () => {
        it('returns undefined if the first number is NaN', () => {
            let num1 = 'a';
            let num2 = 2;
            let expected = testNumbers.sumNumbers(num1, num2);
            expect(expected).to.be.undefined;
        });

        it('returns undefined if the second number is NaN', () => {
            let num1 = 1;
            let num2 = `b`;
            let expected = testNumbers.sumNumbers(num1, num2);
            expect(expected).to.be.undefined;
        });

        it('returns undefined if both numbers are NaNs', () => {
            let num1 = 'a';
            let num2 = `b`;
            let expected = testNumbers.sumNumbers(num1, num2);
            expect(expected).to.be.undefined;
        });

        it('returns the sum of both numbers', () => {
            let num1 = 1;
            let num2 = 0;
            let expected = testNumbers.sumNumbers(num1, num2);
            expect(expected).to.equal('1.00');
        });

        it('returns undefined if the first number is null', () => {
            let num1 = null;
            let num2 = 2;
            let expected = testNumbers.sumNumbers(num1, num2);
            expect(expected).to.be.undefined;
        });

        it('returns undefined if the second number is null', () => {
            let num1 = 1;
            let num2 = null;
            let expected = testNumbers.sumNumbers(num1, num2);
            expect(expected).to.be.undefined;
        });

        it('returns undefined if both numbers are null', () => {
            let num1 = null;
            let num2 = null;
            let expected = testNumbers.sumNumbers(num1, num2);
            expect(expected).to.be.undefined;
        });



        it('returns undefined if the first number is empty string', () => {
            let num1 = '';
            let num2 = 2;
            let expected = testNumbers.sumNumbers(num1, num2);
            expect(expected).to.be.undefined;
        });

        it('returns undefined if the second number is empty string', () => {
            let num1 = 1;
            let num2 = '';
            let expected = testNumbers.sumNumbers(num1, num2);
            expect(expected).to.be.undefined;
        });

        it('returns undefined if both numbers are empty strings', () => {
            let num1 = '';
            let num2 = '';
            let expected = testNumbers.sumNumbers(num1, num2);
            expect(expected).to.be.undefined;
        });

        it('returns the sum of positive nums', () => {
            let num1 = 1;
            let num2 = 2;
            let expected = testNumbers.sumNumbers(num1, num2);
            expect(expected).to.equal('3.00');
        })

        it('returns the sum of the negative nums', () => {
            let num1 = -1;
            let num2 = -2;
            let expected = testNumbers.sumNumbers(num1, num2);
            expect(expected).to.equal('-3.00');
        })

        it('returns the sum of positive floating nums', () => {
            let num1 = 1.549;
            let num2 = 2.5543543;
            let expected = testNumbers.sumNumbers(num1, num2);
            expect(expected).to.equal('4.10');
        })


        it('returns the sum of negative floating nums', () => {
            let num1 = -1.5323;
            let num2 = -2.5534535353;
            let expected = testNumbers.sumNumbers(num1, num2);
            expect(expected).to.equal('-4.09');
        })
    })

    describe('Testing Number Checker Functionality', () => {
        it('throws an error if the input is NaN', () => {
            let input = 'a';
            let expected = testNumbers.numberChecker.bind(input);
            expect(expected).to.throw('The input is not a number!');
            // expect(expected).to.throw;
            // expect(() => testNumbers.numberChecker('a')).to.throw;
        })

        it('returns message: "The number is even!"', () => {
            let even = 2;
            let expected = testNumbers.numberChecker(even);
            expect(expected).to.contain('The number is even!');
        })

        it('returns message: "The number is even!"', () => {
            let even = '8';
            let expected = testNumbers.numberChecker(even);
            expect(expected).to.contain('The number is even!');
        })

        it('returns message: "The number is odd!"', () => {
            let even = 1;
            let expected = testNumbers.numberChecker(even);
            expect(expected).to.contain('The number is odd!');
        })

        it('returns message: "The number is odd!"', () => {
            let even = '9';
            let expected = testNumbers.numberChecker(even);
            expect(expected).to.contain('The number is odd!');
        })
    })

    describe('Testing Average Sum Array Functionality', () => {
        it('returns the average sum of an array', () => {
            let arr = [1, 2, 3, 4, 5];
            let expected = testNumbers.averageSumArray(arr);
            expect(expected).to.equal(3);
        })

        it('returns the average sum of an array', () => {
            let arr = [1.2, -2, -3.43554, 4.0494994, 0];
            let expected = testNumbers.averageSumArray(arr);
            expect(expected).to.equal(-0.037208120000000025);
        })

        it('returns the average sum of an array', () => {
            let arr = [0];
            let expected = testNumbers.averageSumArray(arr);
            expect(expected).to.equal(0);
        })

        it('returns the average sum of an array', () => {
            let arr = [0, 0, 0];
            let expected = testNumbers.averageSumArray(arr);
            expect(expected).to.equal(0);
        })

        it('returns the average sum of an array', () => {
            let arr = [-1, -2, -3, -4, -5];
            let expected = testNumbers.averageSumArray(arr);
            expect(expected).to.equal(-3);
        })
    })
})



// refactoring

/*
describe('Test Numbers', () => {

    describe('Sum Numbers', () => {
        it('If one of the numbers is not a number returs undefined', () => {
            expect(testNumbers.sumNumbers('a', 2)).to.be.undefined;
            expect(testNumbers.sumNumbers(1, 'str')).to.be.undefined;
            expect(testNumbers.sumNumbers('str', 'str')).to.be.undefined;
            expect(testNumbers.sumNumbers(null, 1)).to.be.undefined;
            expect(testNumbers.sumNumbers(1, null)).to.be.undefined;
            expect(testNumbers.sumNumbers(null, null)).to.be.undefined;
            expect(testNumbers.sumNumbers(1, undefined)).to.be.undefined;
            expect(testNumbers.sumNumbers(undefined, 1)).to.be.undefined;
            expect(testNumbers.sumNumbers(undefined, undefined)).to.be.undefined;
            expect(testNumbers.sumNumbers(1)).to.be.undefined;
            expect(testNumbers.sumNumbers()).to.be.undefined;
        });

        it('Returns the sum of the numbers as a string', () => {
            expect(testNumbers.sumNumbers(-1, 2)).to.equal('1.00');
            expect(testNumbers.sumNumbers(1, -2)).to.equal('-1.00');
            expect(testNumbers.sumNumbers(1, 0)).to.equal('1.00');
            expect(testNumbers.sumNumbers(0, 1)).to.equal('1.00');
            expect(testNumbers.sumNumbers(1.5, -2.5)).to.equal('-1.00');
            expect(testNumbers.sumNumbers(-2,5, 1.5)).to.equal('3.00');
        });
    });

    describe('Number checker', () => {
        it('Throws an error if input is not a number', () => {
            expect(() => testNumbers.numberChecker()).to.throw('The input is not a number!');
            expect(() => testNumbers.numberChecker(undefined)).to.throw('The input is not a number!');
            expect(() => testNumbers.numberChecker('str')).to.throw('The input is not a number!');
            expect(() => testNumbers.numberChecker({})).to.throw('The input is not a number!');
            expect(() => testNumbers.numberChecker(NaN)).to.throw('The input is not a number!');
        });
        it('Returns a message "The number is even"', () => {
            expect(testNumbers.numberChecker(2)).to.equal('The number is even!');
            expect(testNumbers.numberChecker(-2)).to.equal('The number is even!');
            expect(testNumbers.numberChecker(0)).to.equal('The number is even!');
            expect(testNumbers.numberChecker('0')).to.equal('The number is even!');
        });
        it('Returns a message "The number is odd"', () => {
            expect(testNumbers.numberChecker(1)).to.equal('The number is odd!');
            expect(testNumbers.numberChecker(-1)).to.equal('The number is odd!');
            expect(testNumbers.numberChecker('2.2')).to.equal('The number is odd!');
        });
    });

    describe('Average Sum Array', () => {
        it('Returns the average sum of an array', () => {
            expect(testNumbers.averageSumArray([1, 2, 3, 4])).to.equal(2.5);
            expect(testNumbers.averageSumArray([-1, -2, -3, -4])).to.equal(-2.5);
            expect(testNumbers.averageSumArray([-1.1, -2.2, -3.3, -4.4])).to.equal(-2.75);
            expect(testNumbers.averageSumArray([1.1, 2.2, 3.3, 4.4])).to.equal(2.75);
            expect(testNumbers.averageSumArray([0])).to.equal(0);
        });
    });

});
*/
