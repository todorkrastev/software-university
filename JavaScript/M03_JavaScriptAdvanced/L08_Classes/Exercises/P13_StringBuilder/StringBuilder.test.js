let { expect } = require('chai');
let StringBuilder = require('./StringBuilder');

describe('StringBuilder', () => {
    describe('constructor', () => {
        it('should initialize with empty an array if undefined is passed', () => {
            let sb = new StringBuilder(undefined);
            expect(sb.toString()).to.equal('');
        })

        it('should throw error if a non-string argument is passed', () => {
            expect(() => new StringBuilder(1.23)).to.throw(TypeError);
            expect(() => new StringBuilder(null)).to.throw(TypeError);
        })

        it('should initialize an array properly when a valid string is passed', () => {
            let sb1 = new StringBuilder('Dominique');
            let sb2 = new StringBuilder('Shanecè');

            expect(sb1.toString()).to.equal('Dominique');
            expect(sb2.toString()).to.equal('Shanecè');
        })
    })

    describe('append', () => {
        it('should throw an exception when a non-string argument is passed', () => {
            let sb1 = new StringBuilder();
            let sb2 = new StringBuilder('abc');

            expect(() => sb1.append(true)).to.throw(TypeError);
            expect(() => sb2.append(123)).to.throw(TypeError);
        })

        it('should append string properly when a string argument is passed', () => {
            let input1 = '-';
            let input2 = 'Shanecè';
            let expected1 = 'Dominique-';
            let expected2 = 'Dominique-Shanecè';
            let sb = new StringBuilder('Dominique');
            sb.append(input1);
            expect(sb.toString()).to.equal(expected1);
            sb.append(input2);
            expect(sb.toString()).to.equal(expected2);
        })

        it('should append only chars when a string argument is passed', () => {
            let input1 = '123';
            let input2 = 'wow';
            let expected1 = 'abc123';
            let expected2 = 'abc123wow';
            let expected3 = 'abc123ww'
            let sb = new StringBuilder('abc');
            sb.append(input1);
            expect(sb.toString()).to.equal(expected1);
            sb.append(input2);
            expect(sb.toString()).to.equal(expected2);
            sb.remove(7, 1);
            expect(sb.toString()).to.equal(expected3);
        })
    })

    describe('prepend', () => {
        it('should throw an exception when a non-string argument is passed', () => {
            let sb1 = new StringBuilder();
            let sb2 = new StringBuilder('abc');

            expect(() => sb1.prepend(true)).to.throw(TypeError);
            expect(() => sb2.prepend(123)).to.throw(TypeError);
        })

        it('should prepend string properly when a string argument is passed', () => {
            let input1 = '-';
            let input2 = 'Shanecè';
            let expected1 = '-Dominique';
            let expected2 = 'Shanecè-Dominique';
            let sb = new StringBuilder('Dominique');
            sb.prepend(input1);
            expect(sb.toString()).to.equal(expected1);
            sb.prepend(input2);
            expect(sb.toString()).to.equal(expected2);
        })

        it('should prepend chars at the corresponding index when a string argument is passed', () => {
            let input1 = '123';
            let input2 = 'wow';
            let expected1 = '123abc';
            let expected2 = 'wow123abc';
            let expected3 = 'wow123bc';
            let sb = new StringBuilder('abc');
            sb.prepend(input1);
            expect(sb.toString()).to.equal(expected1);
            sb.prepend(input2);
            expect(sb.toString()).to.equal(expected2);
            sb.remove(6, 1);
            expect(sb.toString()).to.equal(expected3);
        })
    })

    describe('insertAt', () => {
        it('should throw an exception when a non-string argument is passed', () => {
            let sb1 = new StringBuilder();
            let sb2 = new StringBuilder('abc');

            expect(() => sb1.insertAt(true, 0)).to.throw(TypeError);
            expect(() => sb2.insertAt(123, 1)).to.throw(TypeError);
        })

        it('should insert chars at corresponding index when a valid string is passed', () => {
            let input1 = ' fast';
            let input2 = ' are';
            let expected1 = 'cars fast';
            let expected2 = 'cars are fast';
            let sb = new StringBuilder('cars');
            sb.insertAt(input1, 4);
            expect(sb.toString()).to.equal(expected1);
            sb.insertAt(input2, 4);
            expect(sb.toString()).to.equal(expected2);
        })

        it('should insert chars at corresponding index when a valid string is passed', () => {
            let input1 = ' fast';
            let input2 = ' are';
            let expected1 = 'cars fast';
            let expected2 = 'cars are fast';
            let expected3 = 'cars are fat';
            let sb = new StringBuilder('cars');
            sb.insertAt(input1, 4);
            expect(sb.toString()).to.equal(expected1);
            sb.insertAt(input2, 4);
            expect(sb.toString()).to.equal(expected2);
            sb.remove(11, 1);
            expect(sb.toString()).to.equal(expected3);
        })
    })

    describe('remove', () => {
        it('should insert chars at corresponding index', () => {
            let expected1 = 'cars are fat';
            let expected2 = 'cars fat';
            let sb = new StringBuilder('cars are fast');
            sb.remove(11, 1);
            expect(sb.toString()).to.equal(expected1);
            sb.remove(4, 4);
            expect(sb.toString()).to.equal(expected2);
        })
    })

    describe('toString', () => {
        it('should return the corresponding string', () => {
            let expected1 = '';
            let expected2 = 'cars are fast';
            let sb1 = new StringBuilder();
            let sb2 = new StringBuilder('cars are fast');
            
            expect(sb1.toString()).to.equal(expected1);
            expect(sb2.toString()).to.equal(expected2);
        })
    })
})