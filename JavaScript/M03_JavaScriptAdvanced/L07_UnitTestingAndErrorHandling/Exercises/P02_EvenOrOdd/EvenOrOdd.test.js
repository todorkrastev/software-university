const isOddOrEven = require('./EvenOrOdd');
const { expect } = require('chai');

describe('Testing Odd/Even Functionality', () => {
    it('returns undefined if passed value is not a string', () => {
        let num = 9;
        let actual = isOddOrEven(num);
        expect(actual).to.be.undefined; // or -> expect(actual).to.equal(undefined);
    });

    it('returns undefined if it is not passed any param to the function', () => {
        expect(isOddOrEven()).to.be.undefined;
    });

    it('returns even if we pass the function a value of even length', () => {
        let evenStr = 'aa';
        let actual = isOddOrEven(evenStr);
        let expected = 'even';
        expect(actual).to.equal(expected);
    });

    it('returns odd if we pass the function a value of odd length', () => {
        let oddStr = 'a';
        let actual = isOddOrEven(oddStr);
        let expected = 'odd';
        expect(actual).to.equal(expected);
    });
});