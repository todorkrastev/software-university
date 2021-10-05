function generateReport() {
    let info = document.querySelectorAll('input');
    let table = document.querySelectorAll('tbody tr');

    let tableArray = new Array(table)[0];

    console.log(info);
    console.log(table);
    console.log(tableArray[0]);
    let output = [];
    for (let i = 0; i < table.length; i++) {
        let employerInfo = {};
        for (let k = 0; k < info.length; k++) {
            if (info[k].checked === true) {
                let label = info[k].name;
                let res = tableArray[i].textContent.split("\n").map(x => x.trim(" ")).filter(x => x !== "")[k];
                employerInfo[label] = res;
            }
        }
        output.push(employerInfo);
    }
    console.log(output);

    let outputResult = JSON.stringify(output);
    let divOutput = document.getElementById('output');

    divOutput.textContent = outputResult;
}
