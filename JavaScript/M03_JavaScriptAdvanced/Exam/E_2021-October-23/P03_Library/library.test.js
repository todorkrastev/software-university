const library = require('./library');
const { expect } = require('chai');
const { findBook } = require('./library');

describe("Test library", function () {

    describe("Test calcPriceOfBook ", function () {
        it("incorrect input", function () {
            expect(() => library.calcPriceOfBook(2, 2)).to.throw('Invalid input');
        });

        it("incorrect input", function () {
            expect(() => library.calcPriceOfBook(2, 'a')).to.throw('Invalid input');
        });

        it("incorrect input", function () {
            expect(() => library.calcPriceOfBook('a', 2.2)).to.throw('Invalid input');
        });

        it("incorrect input", function () {
            expect(() => library.calcPriceOfBook(2, '2')).to.throw('Invalid input');
        });

        it("incorrect input", function () {
            expect(() => library.calcPriceOfBook(2, -1)).to.throw('Invalid input');
        });

        it("year bigger than 1980 return price", function () {
            expect(library.calcPriceOfBook('a', 1981)).to.equal('Price of a is 20.00');
        });

        it("year less than 1980 return price", function () {
            expect(library.calcPriceOfBook('a', 1979)).to.equal('Price of a is 10.00');
        });

        it("year equal to 1980 return price", function () {
            expect(library.calcPriceOfBook('a', 1980)).to.equal('Price of a is 10.00');
        });

    });

    describe("Test findBook", function () {
        it("arr of book is zero", function () {
            expect(() => library.findBook([], 'Troy')).to.throw('No books currently available');
        });

        it("when book is not in the arr", function () {
            expect(library.findBook(['a'], 'Troy')).to.equal('The book you are looking for is not here!');
        });

        it("When the book is in the arr", function () {
            expect(library.findBook(['Troy'], 'Troy')).to.equal('We found the book you want.');
        });

    });

    describe("АrrangeTheBooks ", function () {
        it("Number is not integer", function () {
            expect(() => library.arrangeTheBooks('2')).to.throw('Invalid input');
        });

        it("Number is not integer", function () {
            expect(() => library.arrangeTheBooks(2.2)).to.throw('Invalid input');
        });

        it("Number is negative integer", function () {
            expect(() => library.arrangeTheBooks(-2)).to.throw('Invalid input');
        });

        it("Number is negative not integer", function () {
            expect(() => library.arrangeTheBooks(-2.2)).to.throw('Invalid input');
        });

        it("When countBooks equal avaible space", function () {
            expect(library.arrangeTheBooks(40)).to.equal('Great job, the books are arranged.');
        });

        it("When countBooks is less than avaible space", function () {
            expect(library.arrangeTheBooks(39)).to.equal('Great job, the books are arranged.');
        });

        it("When countBooks is more than avaible space", function () {
            expect(library.arrangeTheBooks(41)).to.equal('Insufficient space, more shelves need to be purchased.');
        });

    });

});



// second option


// describe('library', () => {
//     describe('calcPriceOfBook', () => {
//         it('invalid input should throw', () => {
//             expect(() => library.calcPriceOfBook(1, 1990)).to.throw("Invalid input");
//             expect(() => library.calcPriceOfBook(1990)).to.throw("Invalid input");
//             expect(() => library.calcPriceOfBook({}, 1990)).to.throw("Invalid input");
//             expect(() => library.calcPriceOfBook('test', 'year')).to.throw("Invalid input");
//             expect(() => library.calcPriceOfBook()).to.throw("Invalid input");
//             expect(() => library.calcPriceOfBook('test')).to.throw("Invalid input");
//         });

//         it('should return discount if year < 1990', () => {
//             expect(library.calcPriceOfBook('Title', 1980)).to.equal('Price of Title is 10.00');
//             expect(library.calcPriceOfBook('Title', 1979)).to.equal('Price of Title is 10.00');
//             expect(library.calcPriceOfBook('Title', 1960)).to.equal('Price of Title is 10.00');
//         });

//         it('should return standart price when year greater than 1980', () => {
//             expect(library.calcPriceOfBook('Title', 1981)).to.equal('Price of Title is 20.00');
//             expect(library.calcPriceOfBook('Title', 1990)).to.equal('Price of Title is 20.00');
//         });
//     });

//     describe('findBook ', () => {
//         it('should trhow error if no books', () => {
//             expect(() => library.findBook([], 'Title')).to.throw("No books currently available");
//         });

//         it('should give corect result when book found', () => {
//             expect(library.findBook(['Title', 'Some book'], 'Title')).to.equal("We found the book you want.");
//             expect(library.findBook(['Title'], 'Title')).to.equal("We found the book you want.");
//         });

//         it('should give corect result when NO book found', () => {
//             expect(library.findBook(['Title', 'Some book'], 'Test')).to.equal("The book you are looking for is not here!");
//             expect(library.findBook(['Title'], 'Some book')).to.equal("The book you are looking for is not here!");
//         });
//     });

//     describe('arrangeTheBooks ', () => {
//         it('should throw error if invalid input', () => {
//             expect(() => library.arrangeTheBooks('test')).to.throw('Invalid input');
//             expect(() => library.arrangeTheBooks(-1)).to.throw('Invalid input');
//             expect(() => library.arrangeTheBooks(-10)).to.throw('Invalid input');
//             expect(() => library.arrangeTheBooks()).to.throw('Invalid input');
//         });

//         it('should return GREAT JOB when correct input', () => {
//             expect(library.arrangeTheBooks(30)).to.equal('Great job, the books are arranged.');
//             expect(library.arrangeTheBooks(40)).to.equal('Great job, the books are arranged.');
//         });

//         it('should return Insufficient space when books are more', () => {
//             expect(library.arrangeTheBooks(41)).to.equal("Insufficient space, more shelves need to be purchased.");
//             expect(library.arrangeTheBooks(50)).to.equal("Insufficient space, more shelves need to be purchased.");
//         });
//     });
// });