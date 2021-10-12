class Stringer {
    constructor(string, length) {
        this.innerString = string;
        this.innerLength = length;
    }

    increase(value) {
        this.innerLength += value;
    }
    decrease(value) {
        const result = this.innerLength - value;
        this.innerLength = result < 0 ? 0 : result;
    }

    toString() {
        if (this.innerLength === 0) return '...';

        if (this.innerString.length > this.innerLength) {
            return `${this.innerString.slice(0, this.innerLength)}...`;
        }

        return this.innerString;
    }
}
