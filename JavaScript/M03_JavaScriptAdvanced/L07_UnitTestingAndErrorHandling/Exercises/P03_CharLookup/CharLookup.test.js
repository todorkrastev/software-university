const lookupChar = require('./CharLookup');
const { expect } = require('chai');

describe('Testing Char Functionality', () => {
    it('returns undefined if the passed input for string is not a string', () => {
        let inputString = 9;
        let value = 0;
        let actual = lookupChar(inputString, value);
        expect(actual).to.be.undefined;
    });

    it('returns undefined if the passed input for index is not an integer', () => {
        let str = 'Dominique-Shanecé';
        let inputIndex = 'a';
        let actual = lookupChar(str, inputIndex);
        expect(actual).to.be.undefined;
    });

    it('returns undefined if the passed input for index is floating', () => {
        let str = 'Dominique-Shanecé';
        let inputIndex = 1.2;
        let actual = lookupChar(str, inputIndex);
        expect(actual).to.be.undefined;
    });

    it('returns undefined if the passed parameter is only one', () => {
        let value = 9;
        let actual = lookupChar(value);
        expect(actual).to.be.undefined;
    });

    it('returns undefined if there are no passed parameters', () => {
        let actual = lookupChar();
        expect(actual).to.be.undefined;
    });

    it('returns "Incorrect index" if the passed index is bigger than the string length', () => {
        let str = 'Dominique-Shanecé';
        let index = 18;
        let actual = lookupChar(str, index);
        let expected = 'Incorrect index';
        expect(actual).to.equal(expected);
    });

    
    it('returns "Incorrect index" if the passed index is equal to the string length', () => {
        let str = 'Dominique-Shanecé';
        let index = 17;
        let actual = lookupChar(str, index);
        let expected = 'Incorrect index';
        expect(actual).to.equal(expected);
    });

    it('returns "Incorrect index" if the passed index is less than zero', () => {
        let str = 'Dominique-Shanecé';
        let index = -1;
        let actual = lookupChar(str, index);
        let expected = 'Incorrect index';
        expect(actual).to.equal(expected);
    });

    it('returns the character at the specified index in the string', () => {
        let str = 'Dominique-Shanecé';
        let index = 0;
        let actual = lookupChar(str, index);
        let expected = 'D';
        expect(actual).to.equal(expected);
    });

    it('returns the character at the specified index in the string', () => {
        let str = 'Dominique-Shanecé';
        let index = 6;
        let actual = lookupChar(str, index);
        let expected = 'q';
        expect(actual).to.equal(expected);
    });
});
