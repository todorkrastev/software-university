describe('Test Cinema', () => {
    describe('Test showMovies functionality', () => {
        it('return movies as expected', () => {
            expect(cinema.showMovies(['King Kong', 'Hobbit'])).to.equal('King Kong, Hobbit');
            expect(cinema.showMovies(['King Kong'])).to.equal('King Kong');
        });

        it('return message if length of array is zero', () => {
            expect(cinema.showMovies([])).to.equal('There are currently no movies to show.');
            expect(cinema.showMovies('')).to.equal('There are currently no movies to show.');
        });
    });

    describe('Test ticketPrice functionality', () => {
        it('return price according to correct type', () => {
            expect(cinema.ticketPrice('Premiere')).to.equal(12.00);
            expect(cinema.ticketPrice('Normal')).to.equal(7.50);
            expect(cinema.ticketPrice('Discount')).to.equal(5.50);
        });

        it('returns an error if type is incorrect', () => {
            expect(cinema.ticketPrice.bind(('incorrect'))).to.throw('Invalid projection type.');
            expect(cinema.ticketPrice.bind((''))).to.throw('Invalid projection type.');
            expect(cinema.ticketPrice.bind((33))).to.throw('Invalid projection type.');
        });
    });

    describe('Test swapSeatsInHall functionality', () => {
        it('returns message if successful swap', () => {
            expect(cinema.swapSeatsInHall(2, 4)).to.equal('Successful change of seats in the hall.');
            expect(cinema.swapSeatsInHall(19, 1)).to.equal('Successful change of seats in the hall.');
            expect(cinema.swapSeatsInHall(1, 20)).to.equal('Successful change of seats in the hall.');
        });

        it('returns message if unsuccessful swap', () => {
            expect(cinema.swapSeatsInHall(-1, 2)).to.equal('Unsuccessful change of seats in the hall.');
            expect(cinema.swapSeatsInHall(22, 21)).to.equal('Unsuccessful change of seats in the hall.');
            expect(cinema.swapSeatsInHall('2', 2)).to.equal('Unsuccessful change of seats in the hall.');
            expect(cinema.swapSeatsInHall(2, 0)).to.equal('Unsuccessful change of seats in the hall.');
            expect(cinema.swapSeatsInHall(0, 2)).to.equal('Unsuccessful change of seats in the hall.');
        });
    });
});