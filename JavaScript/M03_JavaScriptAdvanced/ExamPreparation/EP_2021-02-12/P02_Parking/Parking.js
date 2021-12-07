class Parking {
    constructor(capacity) {
        this.capacity = capacity;
        this.vehicles = [];
    }

    addCar(carModel, carNumber) {

        if (this.capacity <= this.vehicles.length) {
            throw new Error('Not enough parking space.');
        }

        this.vehicles.push({
            carModel,
            carNumber,
            payed: false
        });

        return `The ${carModel}, with a registration number ${carNumber}, parked.`;
    }

    removeCar(carNumber) {

        if (this.vehicles.some(v => v.carNumber === carNumber) === false) {
            throw new Error(`The car, you're looking for, is not found.`);
        }

        let car = this.vehicles.find(c => c.carNumber === carNumber);
        if (car.payed === false) {
            throw new Error(`${carNumber} needs to pay before leaving the parking lot.`);
        }

        let index = this.vehicles.findIndex(c => c.carNumber === carNumber);
        // let index = this.vehicles.indexOf(car);
        this.vehicles.splice(index, 1);

        return `${carNumber} left the parking lot.`;
    }

    pay(carNumber) {

        if (this.vehicles.some(c => c.carNumber === carNumber) === false) {
            throw new Error(`${carNumber} is not in the parking lot.`);
        }

        let car = this.vehicles.find(c => c.carNumber === carNumber);
        if (car.payed === true) {
            throw new Error(`${carNumber}'s driver has already payed his ticket.`);
        }

        car.payed = true;

        return `${carNumber}'s driver successfully payed for his stay.`;

    }

    getStatistics(carNumber) {

        let output = [];
        if (carNumber === undefined) {
            output.push(`The Parking Lot has ${this.capacity - this.vehicles.length} empty spots left.`);
            let sorted = this.vehicles.sort((a, b) => a.carModel.localeCompare(b.carModel));
            sorted.forEach(c => output.push(`${c.carModel} == ${c.carNumber} - ${c.payed === true ? 'Has payed' : 'Not payed'}`));
        } else {
            let car = this.vehicles.find(c => c.carNumber === carNumber);
            output.push(`${car.carModel} == ${car.carNumber} - ${car.payed ? 'Has payed' : 'Not payed'}`);
        }

        return output.join('\n');
    }
}

const parking = new Parking(12);

console.log(parking.addCar("Volvo t600", "TX3691CA"));
console.log(parking.getStatistics());

console.log(parking.pay("TX3691CA"));
console.log(parking.removeCar("TX3691CA"));

// The Volvo t600, with a registration number TX3691CA, parked.
// The Parking Lot has 11 empty spots left.
// Volvo t600 == TX3691CA - Not payed
// TX3691CA's driver successfully payed for his stay.
// TX3691CA left the parking lot.

