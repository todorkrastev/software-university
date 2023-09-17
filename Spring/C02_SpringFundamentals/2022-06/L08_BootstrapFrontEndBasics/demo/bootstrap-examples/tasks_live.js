// function sortArray(arr, order) {
//     let sortingNumbers = (a, b) => a - b
//     if(order === "asc") {
//         return arr.sort(sortingNumbers)
//     }

//     return arr.sort(sortingNumbers).reverse()
// }

// console.log(sortArray([14, 7, 17, 6, 8], 'asc'))
// console.log(sortArray([14, 7, 17, 6, 8], 'desc'))

// function argumentInfo() {
//     let typeCounts = []
    
//     let values = Object.values(arguments)
//     for (const arg of values) {
//         let type = typeof arg
//         console.log(type + ": " + arg)

//         let typeElement = typeCounts.find(el => {
//             return el[0] === type
//         })

//         if(typeElement) {
//             typeElement[1] = typeElement[1] + 1
//         } else {
//             typeCounts.push([type, 1])
//         }
//     }

//     typeCounts.sort((a, b) => b[1] - a[1])
//         .forEach(el => console.log(el[0] + " = " + el[1]))
// }

// argumentInfo('cat', 42, function () { console.log('Hello world!'); }, 43)

// function personalBMI(name, age, weight, height) {
//     let heightMeters = height/100
//     let bmi = weight/(heightMeters * heightMeters)

//     let status
//     if(bmi < 18.5) {
//         status = "underweight"
//     } else if(bmi < 25) {
//         status = "normal"
//     } else if(bmi < 30) {
//         status = "overweight"
//     } else {
//         status = "obese"
//     }

//     let person = {
//         name: name,
//         personalInfo: {
//             age: age,
//             weight: weight,
//             height: height
//         },
//         bmi: Math.round(bmi),
//         status: status
//     }

//     if (status == "obese") {
//         person.recommendation = "admission required"
//     }

//     return person
// }

// console.log(personalBMI("Peter", 29, 75, 182))
// console.log(personalBMI("Honey Boo Boo", 9, 57, 137))

function heroicInventory(arr) {
    return JSON.stringify(arr.map(str => {
        let tokens = str.split(" / ")
        return {
            name: tokens[0],
            level: +tokens[1],
            items: tokens[2].split(", ")
        }
    }))
}

console.log("asd" == 'asd')

console.log(heroicInventory(['Isacc / 25 / Apple, GravityGun',
'Derek / 12 / BarrelVest, DestructionSword',
'Hes / 1 / Desolator, Sentinel, Antara']))
console.log(heroicInventory(['Jake / 1000 / Gauss, HolidayGrenade']))