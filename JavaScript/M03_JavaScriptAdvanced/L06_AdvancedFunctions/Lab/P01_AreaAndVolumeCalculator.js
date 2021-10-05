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
}



// modification


// function solve(area, vol, input) {
//     return JSON.parse(input)
//         .map(figure => ({
//             area: area.call(figure),
//             volume: vol.call(figure)
//         }));
// }
