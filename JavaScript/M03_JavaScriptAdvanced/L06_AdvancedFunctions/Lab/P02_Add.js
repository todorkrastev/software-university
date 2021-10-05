function solution(input) {
    const initialNum = Number(input);
    return function add(numberToAdd) {
        return initialNum + Number(numberToAdd);
    }
}
