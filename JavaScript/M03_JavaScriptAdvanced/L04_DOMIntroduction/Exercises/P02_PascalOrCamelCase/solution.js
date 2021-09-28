function solve() {
    document.getElementById('result').textContent = '';
    let text = [];
    text = document.getElementById('text').value;
    text = text.toLowerCase();
    text = text.split(' ');
    let namingConvention = document.getElementById('naming-convention').value;

    let result = [];
    switch (namingConvention) {
        case 'Camel Case':
            for (let index = 0; index < text.length; index++) {
                let currWord = text[index];
                if (index !== 0) {
                    result.push(currWord[0].toUpperCase() + currWord.substring(1));
                } else {
                    result.push(currWord);
                }

            }
            break;
        case 'Pascal Case':
            for (let index = 0; index < text.length; index++) {
                let currWord = text[index];
                result.push(currWord[0].toUpperCase() + currWord.substring(1));
            }
            break;
        default:
            result.push('Error!');
            break;
    }
    document.getElementById('result').textContent = result.join('');

    // second option

    // const data = {
    //     case: document.getElementById("naming-convention").value,
    //     str: document.getElementById("text").value,
    //     resultSpan: document.getElementById("result"),
    // }
    // const result = data.str
    //     .split(" ")
    //     .map(x => x.toLocaleLowerCase())
    //     .map(x => `${x.charAt(0).toLocaleUpperCase()}${x.slice(1)}`)
    //     .join("")

    // if (data.case !== "Camel Case" && data.case !== "Pascal Case") {
    //     data.resultSpan.innerHTML = "Error!"
    // } else {
    //     data.resultSpan.innerHTML =
    //         data.case === "Pascal Case"
    //             ? result
    //             : `${result.charAt(0).toLocaleLowerCase()}${result.slice(1)}`
    // }

}
