function solve() {
  let div = document.getElementById('output');
  let input = document.getElementById('input').value;
  let splitted = input.split('.');
  let filtered = splitted.filter(sentence => sentence.length > 0);

  for (let i = 0; i < filtered.length; i += 3) {
    let arr = [];
    for (let y = 0; y < 3; y++) {
      if (filtered[i + y]) {
        arr.push(filtered[i + y]);
      }
    }
    let paragraph = arr.join('. ') + '.';
    div.innerHTML += `<p>${paragraph}</p>`;
  }

  // second option

  // const html = {
  //   textField: document.getElementById("input"),
  //   outputDiv: document.getElementById("output"),
  // }
  // const workArr = html.textField.value
  //   .split(".")
  //   .filter(x => x.length >= 1)
  //   .map(x => x.trim())

  // const tagTemplate = (tag, text) => `<${tag}>${text}</${tag}>`
  // let tempIndex = 0

  // html.outputDiv.innerHTML = workArr
  //   .reduce((a, v, i) => {
  //     if (i % 3 === 0 && i !== 0) tempIndex += 1
  //     a[tempIndex] = (a[tempIndex] || "") + `${v}.`
  //     return a
  //   }, [])
  //   .map(x => tagTemplate("p", x))
  //   .join("\n")
}

