function foo(input) {

    let k = input[0];
    let arr = input.slice(1);
    
    let arrFirstK = arr.slice(0,k);
    let arrLastK = arr.slice(-k);
    
    return arrFirstK.join(' ') + '\n' + arrLastK.join(' ');
  
}
