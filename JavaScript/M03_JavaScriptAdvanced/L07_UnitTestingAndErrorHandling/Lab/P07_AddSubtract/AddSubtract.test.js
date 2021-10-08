const createCalculator = require('./AddSubtract');
const { assert, expect } = require('chai');

describe('Testing Calculator Functionality', () => {
    it('returns an object', () => {
        expect(typeof createCalculator()).to.equals('object');
    })
    it('returns an object with method add', () => {
        expect(createCalculator().add()).to.equals('yes');
    })
    it('returns an object with method subtract', () => {
        expect(typeof createCalculator().subtract).to.equals('function');
    })
    it('returns an object with method get', () => {
        expect(typeof createCalculator().get).to.equals('function');
    })
    it('internal sum cannot be modified', () => {
        expect(createCalculator().value).to.equals(undefined);
    })
    it('add method adds parsable input', () => {
        const calc = createCalculator();
        calc.add('1');
        expect(calc.get()).to.equals(1);
    })
    it('subtract method subtracts parsable input', () => {
        const calc = createCalculator();
        calc.add('2');
        calc.subtract('1');
        expect(calc.get()).to.equals(1);
    })
})



// second option


// describe('Testing Calculator Functionality', () => {
//     it('Should be object typeof', () => {
//         let expectedResult = 'object';
//         let actualResult = (typeof createCalculator());
//         assert.equal(expectedResult, actualResult);
//     });
//     it('Should be function typeof', () => {
//         let expectedResult = 'function';
//         let actualResult = (typeof createCalculator().add);
//         assert.equal(expectedResult, actualResult);
//     });
//     it('Check add method in main function', () => {
//         let expectedResult = undefined;
//         let actualResult = (createCalculator().add());
//         assert.equal(expectedResult, actualResult);
//     });
//     it('Check subtract method in main function', () => {
//         let expectedResult = undefined;
//         let actualResult = (createCalculator().subtract());
//         assert.equal(expectedResult, actualResult);
//     });
//     it('Check get method in main function', () => {
//         let expectedResult = 0;
//         let actualResult = (createCalculator().get());
//         assert.equal(expectedResult, actualResult);
//     });
//     it('Check parse numbers and method works', () => {
//         let calc = createCalculator();
//         calc.add('4');
//         calc.subtract('2');
//         let expectedResult = 2;
//         let actualResult = (calc.get());
//         assert.equal(expectedResult, actualResult);
//     });
//     it('Should can`t be modify by outside', () => {
//         let expectedResult = undefined;
//         let actualResult = (createCalculator().value);
//         assert.equal(expectedResult, actualResult);
//     });
//     it('Check parse numbers if works', () => {
//         let calc = createCalculator();
//         calc.add('1');
//         let expectedResult = 1;
//         let actualResult = (calc.get());
//         assert.equal(expectedResult, actualResult);
//     });
// })
