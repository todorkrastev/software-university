function sortArr(arr, sortType) {
    let sortFunction = {
        asc: function (arr) {
            return arr.sort((a, b) => a - b);
        },
        desc: function (arr) {
            return arr.sort((a, b) => b - a);
        }
    }
    let func = sortFunction[sortType];
    return func(arr);



    // modification


    // return sortType === 'asc' ? arr.sort((a, b) => a - b) : arr.sort((a, b) => b - a);
}
