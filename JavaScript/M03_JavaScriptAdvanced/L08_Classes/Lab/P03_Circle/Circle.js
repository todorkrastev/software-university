class Circle {
    constructor(r) {
        this._radius = r;
    }

    get radius() {
        return this._radius;
    }

    set radius(value) {
        if (typeof value != 'number') {
            throw new TypeError('Radius must be a number!');
        }
        this._radius = value;
    }

    get diameter() {
        return this._radius * 2;
    }
    set diameter(value) {
        if (typeof value != 'number') {
            throw new TypeError('Diameter must be a number!');
        }
        this._radius = value / 2;
    }

    get area() {
        return this._radius ** 2 * Math.PI;
    }
}
