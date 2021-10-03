function solve() {
  const table = document.querySelector('table.table tbody');

  const [input, output] = Array.from(document.querySelectorAll('textarea'));
  const [generateBtn, buyBtn] = Array.from(document.querySelectorAll('button'));

  generateBtn.addEventListener('click', generate);
  buyBtn.addEventListener('click', buy);

  function generate(e) {
    const data = JSON.parse(input.value);

    for (let item of data) {
      const row = document.createElement('tr');

      const imgCell = document.createElement('td');
      const nameCell = document.createElement('td');
      const priceCell = document.createElement('td');
      const decFactorCell = document.createElement('td');
      const checkCell = document.createElement('td');

      const img = document.createElement('img');
      img.src = item.img;
      imgCell.appendChild(img);

      const nameP = document.createElement('p');
      nameP.textContent = item.name;
      nameCell.appendChild(nameP);

      const priceP = document.createElement('p');
      priceP.textContent = item.price;
      priceCell.appendChild(priceP);

      const decP = document.createElement('p');
      decP.textContent = item.decFactor;
      decFactorCell.appendChild(decP);

      const check = document.createElement('input');
      check.type = 'checkbox';
      checkCell.appendChild(check);

      row.appendChild(imgCell);
      row.appendChild(nameCell);
      row.appendChild(priceCell);
      row.appendChild(decFactorCell);
      row.appendChild(checkCell);

      table.appendChild(row);
    }
  }
  function buy(e) {
    const furniture = Array
      .from(document.querySelectorAll('input[type="checkbox"]:checked'))
      .map(b => b.parentElement.parentElement)
      .map(r => ({
        name: r.children[1].textContent,
        price: Number(r.children[2].textContent),
        decFactor: Number(r.children[3].textContent)
      }));

    const names = [];
    let total = 0;
    let decFactor = 0;

    for (let item of furniture) {
      names.push(item.name);
      total += item.price;
      decFactor += item.decFactor;
    }
    const result = `Bought furniture: ${names.join(', ')}
Total price: ${total.toFixed(2)}
Average decoration factor: ${decFactor / furniture.length}`;

    output.value = result;
  }



  // modification of the first option


  //   const table = document.querySelector('table.table tbody');

  //   const [input, output] = Array.from(document.querySelectorAll('textarea'));
  //   const [generateBtn, buyBtn] = Array.from(document.querySelectorAll('button'));

  //   generateBtn.addEventListener('click', generate);
  //   buyBtn.addEventListener('click', buy);

  //   const items = [];

  //   function generate(e) {
  //     const data = JSON.parse(input.value);

  //     for (let item of data) {
  //       const checkBox = createElement('input', { type: 'checkbox' });

  //       const row = createElement('tr', {},
  //         td(createElement('img', { src: item.img })),
  //         td(p(item.name)),
  //         td(p(item.price)),
  //         td(p(item.decFactor)),
  //         td(checkBox)
  //       );

  //       items.push({
  //         element: row,
  //         isChecked,
  //         item
  //       });

  //       table.appendChild(row);

  //       function isChecked() {
  //         return checkBox.checked;
  //       }
  //     }
  //   }

  //   function p(...content) {
  //     return createElement('p', {}, ...content);
  //   }

  //   function td(...content) {
  //     return createElement('td', {}, ...content);
  //   }

  //   function createElement(type, props, ...content) {
  //     const element = document.createElement(type);

  //     for (let prop in props) {
  //       element[prop] = props[prop];
  //     }
  //     for (let entry of content) {
  //       if (typeof entry == 'string' || typeof entry == 'number') {
  //         entry = document.createTextNode(entry);
  //       }
  //       element.appendChild(entry);
  //     }

  //     return element;
  //   }
  //   function buy(e) {
  //     const furniture = items
  //       .filter(i => i.isChecked())
  //       .reduce((acc, { item: c }, i, a) => {
  //         acc.names.push(c.name);
  //         acc.total += Number(c.price);
  //         acc.decFactor += Number(c.decFactor) / a.length;
  //         return acc;
  //       }, { names: [], total: 0, decFactor: 0 });

  //     const result = `Bought furniture: ${furniture.names.join(', ')}
  // Total price: ${furniture.total.toFixed(2)}
  // Average decoration factor: ${furniture.decFactor}`;

  //     output.value = result;
  //   }



  // second option


  //   const [generateBtn, buyBtn] = document.getElementsByTagName("button")
  //   const [generateInput, buyOutput] = document.getElementsByTagName("textarea")
  //   const tableBody = document.querySelector("tbody")

  //   const htmlTemplate = ({ img, name, price, decFactor }) => {
  //     const row = document.createElement("tr")

  //     row.innerHTML = `<td><img src=${img}></td>
  // <td><p>${name}</p></td>
  // <td><p>${price}</p></td>
  // <td><p>${decFactor}</p></td>
  // <td><input type="checkbox"/></td>`

  //     return row
  //   }

  //   const generate = () =>
  //     JSON.parse(generateInput.value).forEach(x =>
  //       tableBody.appendChild(htmlTemplate(x))
  //     )

  //   const buy = () => {
  //     const braindeadData = Array.from(
  //       tableBody.querySelectorAll("input[type=checkbox]:checked")
  //     ).map(x =>
  //       Array.from(x.parentNode.parentNode.children)
  //         .slice(1, 4)
  //         .map(
  //           x =>
  //             Number(x.children[0].innerHTML) ||
  //             x.children[0].innerHTML
  //         )
  //     )
  //     const getSum = arr => arr.reduce((a, v) => a + v, 0)

  //     const names = braindeadData.map(x => x[0]).join(", ")
  //     const prices = getSum(braindeadData.map(x => x[1]))
  //     const avFactors =
  //       getSum(braindeadData.map(x => x[2])) / braindeadData.length

  //     buyOutput.value = `Bought furniture: ${names}
  // Total price: ${prices.toFixed(2)}
  // Average decoration factor: ${avFactors}`
  //   }

  //   generateBtn.addEventListener("click", generate)
  //   buyBtn.addEventListener("click", buy)
}
