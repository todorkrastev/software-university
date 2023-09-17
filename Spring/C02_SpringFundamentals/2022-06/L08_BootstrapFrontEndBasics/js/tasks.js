// Lab Task 1
function sortTheArray(data, order) {
    if (order === 'asc') {
        return data.sort((a, b) => a - b)
    }
    return data.sort((a, b) => b - a)
}

const sorted = sortTheArray([14, 7, 17, 6, 8], 'asc')
const sorted2 = sortTheArray([14, 7, 17, 6, 8], 'desc')

console.log(sorted)
console.log(sorted2)


// Lab Task 2
function getTheArguments() {
    const order = []
    Object.keys(arguments).forEach(key => {
        const value = arguments[key]
        const type = typeof value;
        
        const existing = order.find(item => item.type === type)
        if (existing) {
            existing.amount += 1
        } else {
            order.push({ type, amount: 1 })
        }
        console.log(`${type}: ${JSON.stringify(value) || value}`)
    })
    order.forEach(item => {
        console.log(`${item.type}: ${item.amount}`)
    })
}
getTheArguments('cat', 42, { b: 123 }, function () { console.log('Hello world!'); }, { a: 1 })

// Lab 3
function getBMIStatus(bmi) {
    if (bmi < 18.5) {
        return "Underweight";
    } else if (bmi < 25) {
        return "Normal";
    } else if (bmi < 30) {
        return "Overweight";
    } else {
        return "Obese";
    }
}
function calcBMI(name, age, weight, height) {
    const bmi = (weight) / ((height / 100) * (height / 100))
    const rounded = Math.round(bmi)
    return {
        name,
        personalInfo: {
            age,
            weight,
            height
        },
        BMI: rounded,
        status: getBMIStatus(bmi)
    }
}

const a = calcBMI("Peter", 29, 75, 182)
console.log(a)

