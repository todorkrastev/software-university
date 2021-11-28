const { expect } = require('chai');
const cinema = require('./cinema');

describe('Testing Cinema Software Functionality', () => {
    describe('Testing Show Movies Functionality', () => {
        it('returns message: "There are currently no mives to show."', () => {
            let arr = [];
            let actual = cinema.showMovies(arr);
            expect(actual).to.equal('There are currently no movies to show.');
        });

        it('returns message: "There are currently no mives to show."', () => {
            let arr = '';
            let actual = cinema.showMovies(arr);
            expect(actual).to.equal('There are currently no movies to show.');
        });

        it('returns a string of movies joined with comma', () => {
            let arr = ['Rocky', 'Rocky 1', 'Rocky 2'];
            let actual = cinema.showMovies(arr);
            expect(actual).to.equal('Rocky, Rocky 1, Rocky 2');
        });

        it('returns a string of movies joined with comma', () => {
            let arr = ['Rocky'];
            let actual = cinema.showMovies(arr);
            expect(actual).to.equal('Rocky');
        });

        it('returns a string of movies joined with comma and space', () => {
            let arr = [1, 2.5, -3];
            let actual = cinema.showMovies(arr);
            expect(actual).to.equal('1, 2.5, -3');
        });
    });

    describe('Testing Ticket Price Functionality', () => {
        it('throws an error when an invalid projection type is passed', () => {
            let typeOfProjection = 'VIP';
            let actual = cinema.ticketPrice.bind(typeOfProjection);
            expect(actual).to.throw('Invalid projection type.');
        });

        it('throws an error when an empty string is passed', () => {
            let typeOfProjection = '';
            let actual = cinema.ticketPrice.bind(typeOfProjection);
            expect(actual).to.throw('Invalid projection type.');
        });

        it('throws an error when a digit is passed', () => {
            let typeOfProjection = 9;
            let actual = cinema.ticketPrice.bind(typeOfProjection);
            expect(actual).to.throw('Invalid projection type.');
        });

        it('returns price 12.00 when type of projection is Premiere', () => {
            let typeOfProjection = 'Premiere';
            let actual = cinema.ticketPrice(typeOfProjection);
            expect(actual).to.equal(12.00);
        });

        it('returns price 7.50 when type of projection is Normal', () => {
            let typeOfProjection = 'Normal';
            let actual = cinema.ticketPrice(typeOfProjection);
            expect(actual).to.equal(7.50);
        });

        it('returns price 5.50 when type of projection is Discount', () => {
            let typeOfProjection = 'Discount';
            let actual = cinema.ticketPrice(typeOfProjection);
            expect(actual).to.equal(5.50);
        });
    });

    describe('Testing Swap Seats In Hall Functionality', () => {
        it('returns message "Unsuccessful change of seats in the hall." if the first number is a string', () => {
            let num1 = 'a';
            let num2 = 2;
            let actual = cinema.swapSeatsInHall(num1, num2);
            expect(actual).to.equal('Unsuccessful change of seats in the hall.');
        });

        it('returns message "Unsuccessful change of seats in the hall." if the second number is a string', () => {
            let num1 = 1;
            let num2 = 'b';
            let actual = cinema.swapSeatsInHall(num1, num2);
            expect(actual).to.equal('Unsuccessful change of seats in the hall.');
        });

        it('returns message "Unsuccessful change of seats in the hall." when the first number is empty string', () => {
            let num1 = '';
            let num2 = 2;
            let actual = cinema.swapSeatsInHall(num1, num2);
            expect(actual).to.equal('Unsuccessful change of seats in the hall.');
        });

        it('returns message "Unsuccessful change of seats in the hall." when the second number is empty string', () => {
            let num1 = 1;
            let num2 = '';
            let actual = cinema.swapSeatsInHall(num1, num2);
            expect(actual).to.equal('Unsuccessful change of seats in the hall.');
        });

        it('returns message "Unsuccessful change of seats in the hall." when the first number is null', () => {
            let num1 = null;
            let num2 = 2;
            let actual = cinema.swapSeatsInHall(num1, num2);
            expect(actual).to.equal('Unsuccessful change of seats in the hall.');
        });

        it('returns message "Unsuccessful change of seats in the hall." when the second number is null', () => {
            let num1 = 1;
            let num2 = null;
            let actual = cinema.swapSeatsInHall(num1, num2);
            expect(actual).to.equal('Unsuccessful change of seats in the hall.');
        });

        it('returns message "Unsuccessful change of seats in the hall." if the first number is floating', () => {
            let num1 = 1.5;
            let num2 = 2;
            let actual = cinema.swapSeatsInHall(num1, num2);
            expect(actual).to.equal('Unsuccessful change of seats in the hall.');
        });

        it('returns message "Unsuccessful change of seats in the hall." if the second number is floating', () => {
            let num1 = 1;
            let num2 = 2.5;
            let actual = cinema.swapSeatsInHall(num1, num2);
            expect(actual).to.equal('Unsuccessful change of seats in the hall.');
        });

        it('returns message "Unsuccessful change of seats in the hall." if the first number is negative', () => {
            let num1 = -1;
            let num2 = 2;
            let actual = cinema.swapSeatsInHall(num1, num2);
            expect(actual).to.equal('Unsuccessful change of seats in the hall.');
        });

        it('returns message "Unsuccessful change of seats in the hall." if the second number is negative', () => {
            let num1 = 1;
            let num2 = -2;
            let actual = cinema.swapSeatsInHall(num1, num2);
            expect(actual).to.equal('Unsuccessful change of seats in the hall.');
        });

        it('returns message "Unsuccessful change of seats in the hall." if the first number is bigger than 20', () => {
            let num1 = 21;
            let num2 = 2;
            let actual = cinema.swapSeatsInHall(num1, num2);
            expect(actual).to.equal('Unsuccessful change of seats in the hall.');
        });

        it('returns message "Unsuccessful change of seats in the hall." if the second number is bigger than 20', () => {
            let num1 = 1;
            let num2 = 21;
            let actual = cinema.swapSeatsInHall(num1, num2);
            expect(actual).to.equal('Unsuccessful change of seats in the hall.');
        });

        it('returns message "Unsuccessful change of seats in the hall." if the first number is equal to 0', () => {
            let num1 = 0;
            let num2 = 2;
            let actual = cinema.swapSeatsInHall(num1, num2);
            expect(actual).to.equal('Unsuccessful change of seats in the hall.');
        });

        it('returns message "Unsuccessful change of seats in the hall." if the first number is equal to 0', () => {
            let num1 = 15;
            let num2 = 0;
            let actual = cinema.swapSeatsInHall(num1, num2);
            expect(actual).to.equal('Unsuccessful change of seats in the hall.');
        });

        it('returns message "Unsuccessful change of seats in the hall." if the second number is equal to the first one', () => {
            let num1 = 1;
            let num2 = 1;
            let actual = cinema.swapSeatsInHall(num1, num2);
            expect(actual).to.equal('Unsuccessful change of seats in the hall.');
        });

        it('returns message "Successful change of seats in the hall." when both params are valid', () => {
            let num1 = 1;
            let num2 = 2;
            let actual = cinema.swapSeatsInHall(num1, num2);
            expect(actual).to.equal('Successful change of seats in the hall.');
        });

        it('returns message "Successful change of seats in the hall." when both params are valid', () => {
            let num1 = 2;
            let num2 = 1;
            let actual = cinema.swapSeatsInHall(num1, num2);
            expect(actual).to.equal('Successful change of seats in the hall.');
        });


        it('returns message "Successful change of seats in the hall." when both params are valid', () => {
            let num1 = 2;
            let num2 = 20;
            let actual = cinema.swapSeatsInHall(num1, num2);
            expect(actual).to.equal('Successful change of seats in the hall.');
        });

        it('returns message "Successful change of seats in the hall." when both params are valid', () => {
            let num1 = 20;
            let num2 = 1;
            let actual = cinema.swapSeatsInHall(num1, num2);
            expect(actual).to.equal('Successful change of seats in the hall.');
        });
    });
});