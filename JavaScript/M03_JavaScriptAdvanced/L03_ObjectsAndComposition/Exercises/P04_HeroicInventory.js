function printHeroes(arr) {
    let heroes = [];
    arr.forEach(line => {
        let [name, level, items] = line.split(' / ');
        level = Number(level);
        items = items === undefined || items === null ? [] : items.split(', ');
        let hero = { name, level, items };
        heroes.push(hero);
    });
    console.log(JSON.stringify(heroes));

    /*  return JSON.stringify(
          arr
              .map(x => x.split(" / "))
              .reduce((a, v) => {
                  a.push({ name: v[0], level: Number(v[1]), items: v[2] ? v[2].split(", ") : [] })
                  return a
              }, [])
      ) */
}
