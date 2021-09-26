function gcd_two_numbers(x, y) {
    if ((typeof x !== 'number') || (typeof y !== 'number'))
        return false;
    x = Math.abs(x);
    y = Math.abs(y);
    while (y) {
        var t = y;
        y = x % y;
        x = t;
    }
    console.log(x);

    /*  let result = 1
      for (let i = 2; i < 9; i++) {
          result = args.every(x => x % i === 0) ? i : result
      }
  
      return result */
}
