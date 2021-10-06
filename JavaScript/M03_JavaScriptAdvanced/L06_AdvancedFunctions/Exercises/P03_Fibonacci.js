function getFibonator() {
    let num1 = 0;
    let num2 = 1;
    return () => {
        let result = num1 + num2;
        num1 = num2;
        num2 = result;
        return num1;
    };




    // second option


    // let nums = [0, 0];

    // return () => {
    //     const result = nums[0] + nums[1];
    //     nums = [nums[1], nums[1] + nums[0] || 1];
    //     return result || 1;
    // };
}
