class Company {
    constructor() {
        this.departments = new Map();
    }

    static Employee = class Employee {
        constructor(username, salary, position) {
            this.username = username;
            this.salary = salary;
            this.position = position;
        }

        get username() {
            return this._username;
        }

        set username(value) {
            this._validateParameter(value);
            this._username = value;
        }

        get salary() {
            return this._salary;
        }

        set salary(value) {
            this._validateParameter(value);
            if (value < 0) {
                throw new Error('Invalid input!');
            }
            this._salary = value;
        }

        get position() {
            return this._position;
        }

        set position(value) {
            this._validateParameter(value);
            this._position = value;
        }


        _validateParameter(value) {
            if (value === undefined || value === null || value === '') {
                throw new Error('Invalid input!');
            }
        }

        compareTo(other) {
            let result = other.salary - this.salary;
            return result === 0 ?
                this.username.localeCompare(other.username) :
                result;
        }


        toString() {
            return `${this.username} ${this.salary} ${this.position}`;
        }
    }

    addEmployee(username, salary, position, department) {
        if (department === undefined || department === null || department === '') {
            throw new Error('Invalid input!');
        }

        if (!this.departments.has(department)) {
            this.departments.set(department, []);
        }

        let employee = new Company.Employee(username, salary, position);
        let workers = this.departments.get(department);
        workers.push(employee);
        return `New employee is hired. Name: ${username}. Position: ${position}`;
    }

    bestDepartment() {
        let sortedDepartments = [...this.departments]
            .sort(([aName, aWorkers], [bName, bWorkers]) => {
                let aAverageSalary = this._getAverageSalary(aName);
                let bAverageSalary = this._getAverageSalary(bName);
                return bAverageSalary - aAverageSalary;
            });

        let [bestDepartmentName, bestDepartmentWorkers] = sortedDepartments[0];
        bestDepartmentWorkers.sort((a, b) => a.compareTo(b));

        let bestDepartmentString = `Best Department is: ${bestDepartmentName}
Average salary: ${this._getAverageSalary(bestDepartmentName).toFixed(2)}`;
        let workersString = bestDepartmentWorkers.map(x => x.toString()).join('\n');
        return `${bestDepartmentString}\n${workersString}`;
    }

    _getAverageSalary(departmentName) {
        let departmentWorkers = this.departments.get(departmentName);
        let averageSalary = departmentWorkers.reduce((acc, w) => acc + w.salary, 0) / departmentWorkers.length;
        return averageSalary;
    }



//     second option


//     constructor() {
//         this.departments = [];
//     }

//     getDepart(name) {
//         const depart = this.departments.find(x => x.name === name);

//         if (!depart) {
//             const temp = {
//                 name,
//                 employees: [],
//                 salaries: [],
//                 positions: []
//             };
//             this.departments.push(temp);
//             return temp;
//         } else {
//             return depart;
//         }
//     }

//     getSalariesSum = depart => depart.salaries.reduce((a, v) => a + v, 0);

//     bestSalaryDepart = () =>
//         this.departments.sort((a, b) =>
//             this.getSalariesSum(b) / b.salaries.length -
//             this.getSalariesSum(a) / a.salaries.length)[0]

//     addEmployee(...args) {
//         if (
//             args.some(x => x === undefined || x === null || x === '') ||
//             args[1] < 0
//         ) {
//             throw new Error('Invalid input!');
//         }

//         const department = this.getDepart(args[3]);

//         department.employees.push(args[0]);
//         department.salaries.push(args[1]);
//         department.positions.push(args[2]);
//         return `New employee is hired. Name: ${args[0]}. Position: ${args[2]}`;
//     }

//     bestDepartment() {
//         const best = this.bestSalaryDepart();

//         const printData = best.employees
//             .reduce((a, v, i) => {
//                 a[i] = []
//                 a[i].push(v, best.salaries[i], best.positions[i])
//                 return a
//             }, [])
//             .sort((a, b) => b[1] - a[1] === 0
//                 ? a[0].localeCompare(b[0])
//                 : b[1] - a[1])
//             .map(x => x.join(' '))
//             .join('\n');

//         return `Best Department is: ${best.name}
// Average salary: ${(this.getSalariesSum(best) / best.salaries.length).toFixed(2)}
// ${printData}`;
//     }
}
