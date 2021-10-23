class SummerCamp {
    constructor(organizer, location) {
        this.organizer = organizer;
        this.location = location;
        this.priceForTheCamp = { "child": 150, "student": 300, "collegian": 500 };
        this.listOfParticipants = [];
    }

    registerParticipant(name, condition, money) {
        if (!this.priceForTheCamp.hasOwnProperty(condition)) {
            throw new Error("Unsuccessful registration at the camp.");
        }
        if (this.listOfParticipants.some(x => x.name === name)) {
            return `The ${name} is already registered at the camp.`;
        }
        if (this.priceForTheCamp[condition] > money) {
            return `The money is not enough to pay the stay at the camp.`;
        }
        this.listOfParticipants.push({ name, condition, power: 100, wins: 0 });
        return `The ${name} was successfully registered.`;
    }

    unregisterParticipant(name) {
        let current = this.listOfParticipants.findIndex(x => x.name === name);
        if (current === -1) {
            throw new Error(`The ${name} is not registered in the camp.`);
        }
        this.listOfParticipants.splice(current, 1);
        return `The ${name} removed successfully.`;
    }

    timeToPlay(typeOfGame, participant1, participant2) {
        let player1 = this.listOfParticipants.find(x => x.name === participant1);
        let player2 = this.listOfParticipants.find(x => x.name === participant2);
        if (player1 === undefined) {
            throw new Error(`Invalid entered name/s.`);
        }
        if (typeOfGame === 'WaterBalloonFights' && player2 === undefined) {
            throw new Error(`Invalid entered name/s.`);
        }
        if (typeOfGame === 'WaterBalloonFights' && (player1.condition !== player2.condition)) {
            throw new Error(`Choose players with equal condition.`);
        }
        if (typeOfGame === "Battleship") {
            player1.power += 20;
            return `The ${participant1} successfully completed the game ${typeOfGame}.`;
        }
        if (typeOfGame === 'WaterBalloonFights') {
            if (player1.power > player2.power) {
                player1.wins++;
                return `The ${participant1} is winner in the game ${typeOfGame}.`;
            } else if (player1.power < player2.power) {
                player2.wins++;
                return `The ${participant2} is winner in the game ${typeOfGame}.`;
            } else {
                return `There is no winner.`;
            }
        }
    }

    toString() {
        let result = [];
        result.push(`${this.organizer} will take ${this.listOfParticipants.length} participants on camping to ${this.location}`);
        let sorted = this.listOfParticipants.sort((a, b) => b.wins - a.wins);
        for (let el of sorted) {
            result.push(`${el.name} - ${el.condition} - ${el.power} - ${el.wins}`);
        }
        return result.join('\n');
    }
}



// second option


// class SummerCamp {
//     constructor(organizer, location) {
//         this.organizer = organizer,
//             this.location = location,
//             this.priceForTheCamp = { "child": 150, "student": 300, "collegian": 500 },
//             this.listOfParticipants = [];
//     }

//     registerParticipant(name, condition, money) {
//         if (this.priceForTheCamp.hasOwnProperty(condition) == false) {
//             throw new Error('Unsuccessful registration at the camp.');
//         } else if (this.listOfParticipants.some(p => p.name == name)) {
//             return `The ${name} is already registered at the camp.`;
//         } else if (money < this.priceForTheCamp[condition]) {
//             return `The money is not enough to pay the stay at the camp.`;
//         }

//         this.listOfParticipants.push({ name, condition, power: 100, wins: 0 });

//         return `The ${name} was successfully registered.`;
//     }

//     unregisterParticipant(name) {
//         if (this.listOfParticipants.some(p => p.name == name) == false) {
//             throw new Error(`The ${name} is not registered in the camp.`);
//         }

//         const person = this.listOfParticipants.some(p => p.name == name);
//         this.listOfParticipants.splice(person, 1);

//         return `The ${name} removed successfully.`;

//     }

//     timeToPlay(typeOfGame, participant1, participant2) {
//         let gamerOne = this.listOfParticipants.find(g => g.name == participant1);

//         if (!gamerOne) {
//             throw new Error(`Invalid entered name/s.`);
//         }

//         if (typeOfGame == 'Battleship') {
//             gamerOne.power += 20;
//             return `The ${gamerOne.name} successfully completed the game ${typeOfGame}.`;
//         }

//         if (typeOfGame == 'WaterBalloonFights') {

//             let gamerTwo = this.listOfParticipants.find(g => g.name == participant2);

//             if (!gamerOne || !gamerTwo) {
//                 throw new Error(`Invalid entered name/s.`);
//             } else if (gamerOne.condition != gamerTwo.condition) {
//                 throw new Error('Choose players with equal condition.');
//             }

//             if (gamerOne.power > gamerTwo.power) {
//                 gamerOne.wins++;
//                 return `The ${gamerOne.name} is winner in the game ${typeOfGame}.`;
//             } else if (gamerOne.power < gamerTwo.power) {
//                 gamerTwo.wins++;
//                 return `The ${gamerTwo.name} is winner in the game ${typeOfGame}.`;
//             } else {
//                 return `There is no winner.`;
//             }
//         }
//     }

//     toString() {
//         let result = [];
//         result.push(`${this.organizer} will take ${this.listOfParticipants.length} participants on camping to ${this.location}`);
//         const sortedList = this.listOfParticipants.sort((a, b) => b.wins - a.wins);
//         for (let player of sortedList) {
//             result.push(`${player.name} - ${player.condition} - ${player.power} - ${player.wins}`);
//         }

//         return result.join('\n');
//     }
// }



// third option


// class SummerCamp {
//     constructor(organizer, location) {
//         this.organizer = organizer;
//         this.location = location;
//         this.priceForTheCamp = { "child": 150, "student": 300, "collegian": 500 };
//         this.listOfParticipants = [];
//     }

//     registerParticipant(name, condition, money) {
//         if (condition !== "child" && condition !== "student" && condition !== "collegian") {
//             throw new Error(`Unsuccessful registration at the camp.`);
//         }
//         if (this.listOfParticipants.some(x => x.name === name) === true) {
//             return `The ${name} is already registered at the camp.`;
//         }

//         const price = this.priceForTheCamp[condition];
//         if (money < price) {
//             return `The money is not enough to pay the stay at the camp.`;
//         }

//         const newParticipant = {
//             name: name,
//             condition: condition,
//             power: 100,
//             wins: 0
//         };

//         this.listOfParticipants.push(newParticipant);
//         return `The ${name} was successfully registered.`;
//     }

//     unregisterParticipant(name) {
//         const participant = this.listOfParticipants.find(x => x.name === name);
//         if (!participant) {
//             throw new Error(`The ${name} is not registered in the camp.`);
//         }

//         const index = this.listOfParticipants.indexOf(participant);
//         this.listOfParticipants.splice(index, 1);

//         return `The ${name} removed successfully.`;
//     }

//     timeToPlay(typeOfGame, participant1, participant2) {
//         if (typeOfGame === `WaterBalloonFights`) {
//             const player1 = this.listOfParticipants.find(x => x.name === participant1);
//             const player2 = this.listOfParticipants.find(x => x.name === participant2);

//             if (!player1 || !player2) {
//                 throw new Error(`Invalid entered name/s.`);
//             }

//             if (player1.condition !== player2.condition) {
//                 throw new Error(`Choose players with equal condition.`);
//             }

//             if (player1.power > player2.power) {
//                 player1.wins += 1;
//                 return `The ${participant1} is winner in the game ${typeOfGame}.`;
//             } else if (player2.power > player1.power) {
//                 player2.wins += 1;
//                 return `The ${participant2} is winner in the game ${typeOfGame}.`;
//             } else {
//                 return `There is no winner.`;
//             }


//         } else if (typeOfGame === `Battleship`) {
//             const player1 = this.listOfParticipants.find(x => x.name === participant1);
//             if (!player1) {
//                 throw new Error(`Invalid entered name/s.`);
//             }

//             player1.power += 20;
//             return `The ${participant1} successfully completed the game ${typeOfGame}.`;
//         }

//     }

//     toString() {
//         const output = [];
//         const numberOfParticipants = this.listOfParticipants.length;
//         output.push(`${this.organizer} will take ${numberOfParticipants} participants on camping to ${this.location}`);

//         for (const player of this.listOfParticipants.sort((a, b) => b.wins - a.wins)) {
//             output.push(`${player.name} - ${player.condition} - ${player.power} - ${player.wins}`);
//         }
//         return output.join('\n');

//     }
// }