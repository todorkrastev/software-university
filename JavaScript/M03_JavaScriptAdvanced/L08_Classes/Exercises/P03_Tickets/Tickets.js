function tickets(arr, criteria) {
    function splitLines(line) {
        return line.split('|');
    }

    function nameTheTickets([destination, price, status]) {
        return new Tickets(destination, Number(price), status);
    }

    class Tickets {
        constructor(destination, price, status) {
            this.destination = destination;
            this.price = price;
            this.status = status;
        }

    }
    const sortParser = {
        'destination': (a, b) => a.destination.localeCompare(b.destination),
        'price': (a, b) => a.price - b.price,
        'status': (a, b) => a.status.localeCompare(b.status)
    };

    return arr
        .map(splitLines)
        .map(nameTheTickets)
        .sort(sortParser[criteria]);



    // second option


    // class Ticket {
    //     constructor(destination, price, status) {
    //         this.destination = destination;
    //         this.price = price;
    //         this.status = status;
    //     }
    //     compareTo(other, criteria) {
    //         return typeof this[criteria] === 'string' ?
    //             this[criteria].localeCompare(other[criteria]) :
    //             this[criteria] - other[criteria];
    //     }
    // }


    // let tickets = [];

    // arr.forEach(line => {
    //     let [destination, price, status] = line.split('|');
    //     price = Number(price);
    //     let ticket = new Ticket(destination, price, status);
    //     tickets.push(ticket);
    // });

    // return tickets.sort((a, b) => a.compareTo(b, criteria));


    
    // third option


    // class Ticket {
    //     price
    //     constructor(d, p, s) {
    //         this.destination = d;
    //         this.price = p;
    //         this.status = s;
    //     }
    // }

    // return arr.slice().map(x => x.split('|'))
    //     .map(([d, p, s]) => new Ticket(d, Number(p), s))
    //     .sort((a, b) => {
    //         return typeof a[criteria] === 'number'
    //             ? a[criteria] - b[criteria]
    //             : a[criteria].localeCompare(b[criteria]);
    //     });
}
