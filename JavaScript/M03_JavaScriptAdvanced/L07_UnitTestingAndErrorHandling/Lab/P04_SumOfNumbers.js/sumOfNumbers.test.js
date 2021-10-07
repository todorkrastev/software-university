const sum = require('./SumOfNumbers');
const { assert } = require('chai');

describe('Testing summing function', () => {
    it('Test should verify that the summing function is working correctly', () => {
        let arr = [10, 20];
        let expectedResult = 30;
        let actualResult = sum(arr);
        assert.isNumber(actualResult, expectedResult);
    });

    it('Test should verify that one of the elements is NOT a number', () => {
        let arr = [10, 'a'];
        let actualResult = sum(arr);
        assert.isNaN(actualResult);
    });
});
