function cinemaTickets(input) {
    let index = 0;
    let movie = input[index++];
    let totalSeats = Number(input[index++]);
    let student = 0, standard = 0, kid = 0;
    let capacity = 0;

    while (movie != "Finish") {
        let ticket = input[index++];
        while (ticket != "End") {
            if (ticket == "Finish" || ticket == "End") {
                break;
            }
            capacity++;
            switch (ticket) {
                case "standard": standard++;
                    break;
                case "student": student++;
                    break;
                case "kid": kid++;
                    break;
            }
            if (capacity == totalSeats) {
                break;
            }
            ticket = input[index++];
        }
        let pct = (capacity / totalSeats) * 100;
        console.log(`${movie} - ${pct.toFixed(2)}% full.`);

        if (ticket == 'Finish') {
            break;
        }

        movie = input[index++];
        totalSeats = input[index++];
        capacity = 0;
    }
    let totalTickets = student + kid + standard;
    console.log(`Total tickets: ${totalTickets}`);
    console.log(`${((student / totalTickets) * 100).toFixed(2)}% student tickets.`);
    console.log(`${((standard / totalTickets) * 100).toFixed(2)}% standard tickets.`);
    console.log(`${((kid / totalTickets) * 100).toFixed(2)}% kids tickets.`);
}
