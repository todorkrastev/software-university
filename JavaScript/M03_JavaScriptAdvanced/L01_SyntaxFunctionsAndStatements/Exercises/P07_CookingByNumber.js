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
}
