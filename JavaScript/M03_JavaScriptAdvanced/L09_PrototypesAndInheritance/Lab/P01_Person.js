function createPerson(firstName, lastName) {
    const result = {
        firstName,
        lastName,
        fullName: ''
    };

    Object.defineProperty(result, 'fullName', {
        get() {
            return `${this.firstName} ${this.lastName}`
        },
        set(value) {
            const [first, last] = value.split(' ');
            if (first != undefined && last != undefined) {
                this.firstName = first;
                this.lastName = last;
            }
        },
        configurable: true,
        enumerable: true
    });

    return result;
}
