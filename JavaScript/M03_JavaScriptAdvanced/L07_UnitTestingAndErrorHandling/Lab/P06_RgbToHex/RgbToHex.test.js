const rgbToHexColor = require('./RgbToHex');
const { assert } = require('chai');

describe('Testing Converting Function', () => {
    it('Test should check three integer numbers, each within the range [0...255]', () => {
        let red = 200;
        let green = 201;
        let blue = 202;
        let expected = rgbToHexColor(red, green, blue);
        let actual = '#C8C9CA';
        assert.equal(actual, expected);
    });

    it('Test should check if one of the three integer numbers is out of the range [0...255] and should return undefined', () => {
        let red = 300;
        let green = 201;
        let blue = 202;
        let expected = rgbToHexColor(red, green, blue);
        assert.isUndefined(expected);
    });

    it('Test should check if one of the three integer numbers is out of the range [0...255] and should return undefined', () => {
        let red = 200;
        let green = 300;
        let blue = 202;
        let expected = rgbToHexColor(red, green, blue);
        assert.isUndefined(expected);
    });


    it('Test should check if one of the three integer numbers is out of the range [0...255] and should return undefined', () => {
        let red = 200;
        let green = 200;
        let blue = 300;
        let expected = rgbToHexColor(red, green, blue);
        assert.isUndefined(expected);
    });

    it('Test should check if one of the three integer numbers is out of the range [0...255] and should return undefined', () => {
        let red = -200;
        let green = 200;
        let blue = 200;
        let expected = rgbToHexColor(red, green, blue);
        assert.isUndefined(expected);
    });

    it('Test should check if one of the three integer numbers is out of the range [0...255] and should return undefined', () => {
        let red = 200;
        let green = -200;
        let blue = 200;
        let expected = rgbToHexColor(red, green, blue);
        assert.isUndefined(expected);
    });

    it('Test should check if one of the three integer numbers is out of the range [0...255] and should return undefined', () => {
        let red = 200;
        let green = 200;
        let blue = -300;
        let expected = rgbToHexColor(red, green, blue);
        assert.isUndefined(expected);
    });

    it('Test should check if one of the three integer numbers is an invalid type and should return undefined', () => {
        let red = 'a';
        let green = 200;
        let blue = 10;
        let expected = rgbToHexColor(red, green, blue);
        assert.isUndefined(expected);
    });

    it('Test should check if one of the three integer numbers is an invalid type and should return undefined', () => {
        let red = 200;
        let green = 'a';
        let blue = 20;
        let expected = rgbToHexColor(red, green, blue);
        assert.isUndefined(expected);
    });

    it('Test should check if one of the three integer numbers is an invalid type and should return undefined', () => {
        let red = 200;
        let green = 10;
        let blue = 'a';
        let expected = rgbToHexColor(red, green, blue);
        assert.isUndefined(expected);
    });

    it('Test should check if one of the three integer numbers is an empty string and should return undefined', () => {
        let red = '';
        let green = 10;
        let blue = 20;
        let expected = rgbToHexColor(red, green, blue);
        assert.isUndefined(expected);
    });

    it('Test should check if one of the three integer numbers is an empty string and should return undefined', () => {
        let red = 10;
        let green = '';
        let blue = 20;
        let expected = rgbToHexColor(red, green, blue);
        assert.isUndefined(expected);
    });

    it('Test should check if one of the three integer numbers is an empty string and should return undefined', () => {
        let red = 10;
        let green = 20;
        let blue = '';
        let expected = rgbToHexColor(red, green, blue);
        assert.isUndefined(expected);
    });

    it('Test should check if one of the three integer numbers is missing and should return undefined', () => {
        let green = 20;
        let blue = 20;
        let expected = rgbToHexColor(green, blue);
        assert.isUndefined(expected);
    });

    it('Test should check if the params are more than three numbers and should return #000000', () => {
        let red = 0;
        let green = 0;
        let blue = 0;
        let white = 0;
        let expected = rgbToHexColor(red, green, blue, white);
        let actual = '#000000';
        assert.equal(actual, expected);
    });

    it('Test should check random three numbers and should return #FF9EAA', () => {
        let red = 255;
        let green = 158;
        let blue = 170;
        let expected = rgbToHexColor(red, green, blue);
        let actual = '#FF9EAA';
        assert.equal(actual, expected);
    });
});
