function solve() {
    class Employee {
        constructor(name, age, tasks) {
            if (this.constructor === Employee) {
                throw new Error('Cannot instantiate abstract class');
            }

            this.name = name;
            this.age = age;
            this.salary = 0;
            this.tasks = tasks;
            this._currentTask = 0;
        }

        work() {
            let task = this.tasks[this._currentTask].replace('{name}', this.name);
            this._currentTask = (this._currentTask + 1) % this.tasks.length;
            console.log(task);
        }

        _calculateSalary() {
            return this.salary;
        }

        collectSalary() {
            console.log(`${this.name} received ${this._calculateSalary()} this month.`)
        }
    }

    class Junior extends Employee {
        constructor(name, age) {
            super(name, age, [
                '{name} is working on a simple task.'
            ]);
        }
    }

    class Senior extends Employee {
        constructor(name, age) {
            super(name, age, [
                '{name} is working on a complicated task.',
                '{name} is taking time off work.',
                '{name} is supervising junior workers.'
            ]);
        }
    }

    class Manager extends Employee {
        constructor(name, age) {
            super(name, age, [
                '{name} scheduled a meeting.',
                '{name} is preparing a quarterly report.'
            ]);

            this.dividend = 0;
        }

        _calculateSalary() {
            return this.salary + this.dividend;
        }
    }

    return {
        Employee,
        Junior,
        Senior,
        Manager
    }
}

