const mathEnforcer = require('./MathEnforcer');
const { expect } = require('chai');

describe('Testing an Object with 3 functionalities', () => {
    it('returns undefined if there is not passed any parameter', () => {
        let expected = mathEnforcer.addFive();
        expect(expected).to.be.undefined;
    });

    it('returns undefined if the passed parameter is string', () => {
        let inputStr = 'a';
        let expected = mathEnforcer.addFive(inputStr);
        expect(expected).to.be.undefined;
    });

    it('adds 5 to the passed parameter (negative floating number) and returns the result', () => {
        let input = -5.5;
        let expected = mathEnforcer.addFive(input);
        expect(expected).to.be.closeTo(-0.5, 0.01);
    });

    it('adds 5 to the passed parameter (positive floating number) and returns the result', () => {
        let input = 5.5;
        let expected = mathEnforcer.addFive(input);
        expect(expected).to.be.closeTo(10.5, 0.01);
    });

    it('adds 5 to the passed parameter (negative integer) and returns the result', () => {
        let input = -5;
        let expected = mathEnforcer.addFive(input);
        expect(expected).to.equal(0);
    });


    it('adds 5 to the passed parameter (positive integer) and returns the result', () => {
        let input = 5;
        let expected = mathEnforcer.addFive(input);
        expect(expected).to.equal(10);
    });

    it('adds 5 to the passed parameter (0) and returns the result', () => {
        let input = 0;
        let expected = mathEnforcer.addFive(input);
        expect(expected).to.equal(5);
    });

    it('returns undefined if there is not passed any parameter', () => {
        let expected = mathEnforcer.subtractTen();
        expect(expected).to.be.undefined;
    });

    it('returns undefined if the passed parameter is string', () => {
        let inputStr = 'a';
        let expected = mathEnforcer.subtractTen(inputStr);
        expect(expected).to.be.undefined;
    });

    it('subtracts 10 to the passed parameter (negative floating number) and returns the result', () => {
        let input = -5.5;
        let expected = mathEnforcer.subtractTen(input);
        expect(expected).to.be.closeTo(-15.5, 0.01);
    });

    it('subtracts 10 to the passed parameter (positive floating number) and returns the result', () => {
        let input = 5.5;
        let expected = mathEnforcer.subtractTen(input);
        expect(expected).to.be.closeTo(-4.5, 0.01);
    });

    it('subtracts 10 to the passed parameter (negative integer) and returns the result', () => {
        let input = -5;
        let expected = mathEnforcer.subtractTen(input);
        expect(expected).to.be.closeTo(-15, 0.01);
    });

    it('subtracts 10 to the passed parameter (positive integer) and returns the result', () => {
        let input = 5;
        let expected = mathEnforcer.subtractTen(input);
        expect(expected).to.be.closeTo(-5, 0.01);
    });

    it('subtracts 10 to the passed parameter (zero) and returns the result', () => {
        let input = 0;
        let expected = mathEnforcer.subtractTen(input);
        expect(expected).to.be.closeTo(-10, 0.01);
    });

    it('returns undefined if there is not passed any parameter', () => {
        let expected = mathEnforcer.sum();
        expect(expected).to.be.undefined;
    });

    it('returns undefined if one of the params is missing', () => {
        let digit = 2;
        let expected = mathEnforcer.sum(digit);
        expect(expected).to.be.undefined;
    });

    it('returns undefined if the firts passed parameter is string', () => {
        let str = 'a';
        let digit = 2;
        let expected = mathEnforcer.sum(str, digit);
        expect(expected).to.be.undefined;
    });

    it('returns undefined if the second passed parameter is string', () => {
        let digit = 2;
        let str = 'a';
        let expected = mathEnforcer.sum(digit, str);
        expect(expected).to.be.undefined;
    });

    it('retunrs the sum of the passed positive integers', () => {
        let int1 = 5;
        let int2 = 5;
        let expected = mathEnforcer.sum(int1, int2);
        expect(expected).to.equal(10);
    });

    it('retunrs the sum of the passed negative integers', () => {
        let int1 = -5;
        let int2 = -5;
        let expected = mathEnforcer.sum(int1, int2);
        expect(expected).to.equal(-10);
    });

    it('retunrs the sum of the passed positive floating numbers', () => {
        let float1 = 5.5;
        let float2 = 5.5;
        let expected = mathEnforcer.sum(float1, float2);
        expect(expected).to.equal(11);
    });

    it('retunrs the sum of the passed negative floating numbers', () => {
        let float1 = -5.5;
        let float2 = -5.5;
        let expected = mathEnforcer.sum(float1, float2);
        expect(expected).to.be.closeTo(-11, 0.01);
    });

    it('retunrs the sum of the passed positive and negative integers', () => {
        let int1 = -5;
        let int2 = 5;
        let expected = mathEnforcer.sum(int1, int2);
        expect(expected).to.equal(0);
    });

    it('retunrs the sum of the passed positve and negative floating numbers', () => {
        let float1 = 5.5;
        let float2 = -5.5;
        let expected = mathEnforcer.sum(float1, float2);
        expect(expected).to.be.closeTo(0, 0.01);
    });

    it('retunrs the sum of the passed parameters', () => {
        let int = 0;
        let float = 0;
        let expected = mathEnforcer.sum(int, float);
        expect(expected).to.equal(0);
    });
});
