function printResult(arg1, arg2, arg3, arg4, arg5, arg6) {
    let number = Number(arg1);
    const listOfCommands = [arg2, arg3, arg4, arg5, arg6];
    for (let index = 0; index < listOfCommands.length; index++) {
        const currElement = listOfCommands[index];
        switch (currElement) {
            case 'chop':
                number /= 2;
                break;
            case 'dice':
                number = Math.sqrt(number);
                break;
            case 'spice':
                number += 1;
                break;
            case 'bake':
                number *= 3;
                break;
            case 'fillet':
                number *= 0.8;
                break;
            default: break;
        }
        console.log(number);
    }

  /*  let n = Number(args.shift())
    const actions = {
        chop: x => n = x / 2,
        dice: x => n = Math.sqrt(x),
        spice: x => n = x + 1,
        bake: x => n = x * 3,
        fillet: x => n = x - x * 0.2,
    }

    args.forEach(x => console.log(actions[x](n))) */
}
