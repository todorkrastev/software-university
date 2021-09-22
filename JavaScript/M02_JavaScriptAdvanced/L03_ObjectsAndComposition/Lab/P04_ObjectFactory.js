function objectFactory(library, orders) {
    const result = [];

    for (let order of orders) {
        const current = Object.assign({}, order.template);
        for (let part of order.parts) {
            current[part] = library[part];
        }
        result.push(current);
    }

    return result;

    /*  return orders.reduce((a, v) => {
          const temp = {}
          temp.name = v.template.name
          v.parts.forEach(x => {
              temp[x] = library[x]
          })
          a.push(temp)
          return a
      }, []); */
}
