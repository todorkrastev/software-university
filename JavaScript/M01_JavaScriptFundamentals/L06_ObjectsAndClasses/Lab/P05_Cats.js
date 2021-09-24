function foo(arr) {
    let cats = [];
    class cat {
        constructor(name, age) {
            this.name = name;
            this.age = age;
        }
        meow() {
            console.log(`${this.name}, age ${this.age} says Meow`);
        }
    }

    for (let i = 0; i < arr.length; i++) {
        let catData = arr[i].split(' ');
        let [name, age] = [catData[0], catData[1]];
        cats.push(new cat(name, age)); // add a cat with the data above
    }

    for (let cat of cats) {
        cat.meow();
    }
}
