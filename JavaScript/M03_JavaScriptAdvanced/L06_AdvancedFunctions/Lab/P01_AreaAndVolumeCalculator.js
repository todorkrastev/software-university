function solve(area, vol, input) {
    result = [];

    let figures = JSON.parse(input);

    figures.forEach(figure => {
        figArea = area.call(figure);
        figVolume = vol.call(figure);

        result.push({
            area: figArea,
            volume: figVolume
        });
    })

    return result;



    // modification of the first option


    //     return JSON.parse(input)
    //         .map(figure => ({
    //             area: area.call(figure),
    //             volume: vol.call(figure)
    //         }));



    // using Reduce


    // return JSON.parse(inputs).reduce((a, v, i, obj) => {
    //     a.push({
    //         area: area.call(v),
    //         volume: volume.call(v),
    //     });
    //     return a;
    // }, []);
}
