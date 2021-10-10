class List {
    constructor(list = []) {
        this.list = list.sort((a, b) => a - b);
        this.size = this.list.length;
    }
    add(element) {
        this.list.push(element);
        this.list.sort((a, b) => a - b);
        this.size++;
        return;
    }
    remove(index) {
        if (index >= 0 && index < this.list.length) {
            this.list.splice(index, 1);
            this.size--;
            return;
        } else {
            throw new Error('Invalid!');
        }
    }
    get(index) {
        if (index >= 0 && index < this.list.length) {
            return this.list[index];
        } else {
            throw new Error('Invalid!');
        }
    }



    // second option


    // constructor() {
    //     this.list = [];
    //     this.size = this.list.length;
    // }

    // updateSize = () => this.size = this.list.length;
    // orderList = () => this.list.sort((a, b) => a - b);

    // add(e) {
    //     this.list.push(e);
    //     this.updateSize();
    //     this.orderList();
    // }
    // remove(i) {
    //     if (this.list[i] !== undefined) {
    //         this.list.splice(i, 1);
    //         this.updateSize();
    //         this.orderList();
    //     }
    // }
    // get(i) {
    //     if (this.list[i] !== undefined) {
    //         this.updateSize();
    //         this.orderList();
    //         return this.list[i];
    //     }
    // }
}
