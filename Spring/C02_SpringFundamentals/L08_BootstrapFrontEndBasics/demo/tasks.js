//===================
//   Problem 1.
//===================
function sortCustom(arr, order) {
    let sortingF = (a, b) => a - b

    if('asc' == order) {
        return arr.sort(sortingF)
    }

    return arr.sort(sortingF).reverse()
}

console.log(sortCustom([14, 7, 17, 6, 8], 'asc'))
console.log(sortCustom([14, 7, 17, 6, 8], 'desc'))

//===================
//   Problem 2.
//===================
function argumentInfo(... args) {
    let typeMap = {}
    for(const arg of args) {
        console.log((typeof arg) + ": " + (arg))
        let currentCount = typeMap[typeof arg]
        
        if(currentCount) {
            typeMap[typeof arg] = currentCount + 1
        } else {
            typeMap[typeof arg] = 1
        }
    }

    let sortable = []
    for(const key in typeMap) {
        sortable.push([key, typeMap[key]])
    }

    sortable.sort((a, b) => {
        return a[1] - b[1]
    })

    for(const element of sortable) {
        console.log(element[0] + " = " + element[1])
    }
}

argumentInfo('cat', 42, function () { console.log('Hello world!'); })


//===================
//   Problem 3.
//===================
function personalBmi(name, age, weight, height) {
    const bmi = weight/(height*height) * 100 * 100 //acount for units
    let status;
    if(bmi < 18.5) {
        status = "underweight"
    } else if(bmi < 25) {
        status = "normal"
    } else if(bmi < 30) {
        status = "overweight"
    } else {
        status = "obese"
    }

    let personObj = {
        name: name,
        personalInfo: {
            age: age,
            weight: weight,
            height: height
        },
        BMI: bmi,
        status: status
    }

    if(status === "obese") {
        personObj.recommendation = "admission required"
    }

    return personObj
}

console.log(personalBmi("Peter", 29, 75, 182))
console.log(personalBmi("Honey Boo Boo", 9, 57, 137))