function add(a) {
    let sum = 0;
    sum += a;

    function innerAdd(b) {
        sum += b;
        return innerAdd;
    }
    innerAdd.toString = () => sum;
    return innerAdd;



    // second option


    // let temp = 0;

    // function recursive(x) {
    //     temp += x;

    //     return recursive;
    // }
    // recursive.toString = () => temp
    // return recursive(a);
}
