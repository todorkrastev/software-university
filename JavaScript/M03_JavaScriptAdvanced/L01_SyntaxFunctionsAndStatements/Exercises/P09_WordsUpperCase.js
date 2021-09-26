function solve(text) {

    let result = text.toUpperCase()
      .split(/[\W]+/)
      .filter(w => w.length > 0)
      .join(", ");
  
    console.log(result);
    
     /*  let result = text.toUpperCase()
         .match(/\w+/g)
         .join(', ');
       
       console.log(result); */

    //   return s.match(/\w+/g).join(", ").toLocaleUpperCase()
  }
  

