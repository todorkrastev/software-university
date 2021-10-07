const isSymmetric = require('./CheckForSymmetry');
const { assert } = require('chai');

describe('Testing Symmetric Function', () => {
    it('Test should determine if passed value is not an array', () => {
        let arr = { n1: 1 };
        let expected = isSymmetric(arr);
        assert.isNotArray(expected);
    });

    it('Test should return true if passed array is symmetric', () => {
        let arr = [1, 2, 2, 1];
        let expected = isSymmetric(arr);
        assert.isTrue(expected);
    });

    it('Test should return false if passed array is non-symmetric', () => {
        let arr = [1, 2, 1, 1];
        let expected = isSymmetric(arr);
        assert.isFalse(expected);
    });

    it('Test should return false if passed values in array are from different type', () => {
        let arr = ['1', 1];
        let expected = isSymmetric(arr);
        assert.isFalse(expected);
    });
});
