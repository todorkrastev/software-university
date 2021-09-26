function strLen(firstString, secondString, thirdString) {
    let sumOfStrLen = firstString.length + secondString.length + thirdString.length;
    let avgLen = Math.floor(sumOfStrLen / 3);
    console.log(sumOfStrLen);
    console.log(avgLen);

  /*  const length = args.reduce((a, v) => a + v.length, 0)
    return `${length}
${Math.round(length / args.length)}` */
}
