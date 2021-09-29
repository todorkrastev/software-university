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
}

