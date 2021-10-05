function solve(data, criteria) {
    const parsed = JSON.parse(data);
    const [crit, specificCrit] = criteria.split("-");

    return parsed
        .filter(x => x[crit] === specificCrit)
        .map((x, i) => `${i}. ${x.first_name} ${x.last_name} - ${x.email}`)
        .join("\n");
}
