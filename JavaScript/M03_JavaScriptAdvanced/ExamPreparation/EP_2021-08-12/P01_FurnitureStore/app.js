window.addEventListener('load', solve);

function solve() {
    let model = document.querySelector('#model');
    let year = document.querySelector('#year');
    let description = document.querySelector('#description');
    let price = document.querySelector('#price');
    let furnitureList = document.querySelector('#furniture-list');
    let addButton = document.querySelector('#add');
    let totalPrice = document.querySelector('.total-price');

    addButton.addEventListener('click', addFurniture);

    function addFurniture(event) {
        event.preventDefault();

        modelValue = model.value.trim();
        yearValue = Number(year.value.trim());
        descriptionValue = description.value.trim();
        priceValue = Number(price.value.trim());


        if (modelValue == '' || yearValue == '' || descriptionValue == '' || priceValue == '' ||
            Number.isNaN(yearValue) || Number.isNaN(priceValue) ||
            Math.sign(yearValue) === -1 || Math.sign(priceValue) === -1) {
            return;
        }

        const trInfo = document.createElement('tr');
        trInfo.classList.add('info');
        trInfo.innerHTML = `<td>${modelValue}</td>
        <td>${priceValue.toFixed(2)}</td>
        <td>
            <button class = "moreBtn">More Info</button>
            <button class = "buyBtn">Buy it</button>
        </td>`;

        const trHide = document.createElement('tr');
        trHide.classList.add('hide');
        trHide.innerHTML = `<td>Year: ${yearValue}</td>
        <td colspan="3">Description: ${descriptionValue}</td>`

        furnitureList.appendChild(trInfo);
        furnitureList.appendChild(trHide);

        const buttons = trInfo.querySelectorAll('button');
        const moreBtn = buttons[0];
        moreBtn.addEventListener('click', showMoreInfo);
        const buyBtn = buttons[1];
        buyBtn.addEventListener('click', buyFurniture);

        model.value = '';
        year.value = '';
        description.value = '';
        price.value = '';
    }

    function showMoreInfo(event) {
        const moreInfoTr = event.target.parentElement.parentElement.nextElementSibling;

        if (event.target.textContent == 'More Info') {
            event.target.textContent = 'Less Info';
            moreInfoTr.style.display = 'contents';

        } else {
            event.target.textContent = 'More Info';
            moreInfoTr.style.display = 'none';
        }
    }

    function buyFurniture(event) {
        const tr = event.target.parentElement.parentElement;
        const hideTr = tr.nextElementSibling;

        hideTr.parentElement.removeChild(hideTr);

        const priceFurniture = Number(tr.querySelectorAll('.info td')[1].textContent);
        totalPrice.textContent = (Number(totalPrice.textContent) + priceFurniture).toFixed(2);

        tr.parentElement.removeChild(tr);
    }
}



// refactoration

/*
function solve() {
    const modelField = document.getElementById('model');
    const yearField = document.getElementById('year');
    const descriptionField = document.getElementById('description');
    const priceField = document.getElementById('price');
    const addBtn = document.getElementById('add');
    let totalPrice = 0;
    addBtn.addEventListener('click', addHandler);

    function addHandler(event) {
        event.preventDefault();
        const model = modelField.value;
        let year = yearField.value;
        const description = descriptionField.value;
        let price = priceField.value;

        if (model === '' || description === '' ||
            Number.isNaN(Number(year)) || year < 1 ||
            Number.isNaN(Number(price)) || price < 1) {

            return;
        }
        price = Number(price);
        const tBody = document.getElementById('furniture-list');
        const moreLestBtn = e('button', { className: 'moreBtn' }, 'More Info');
        const buyBtn = e('button', { className: 'buyBtn' }, 'Buy it');
        const trInfo = e('tr', { className: 'info' },
            e('td', {}, model),
            e('td', {}, price.toFixed(2)),
            e('td', {}, moreLestBtn, buyBtn));
        const trHide = e('tr', { className: 'hide' },
            e('td', {}, `Year: ${year}`),
            e('td', { colSpan: '3' }, `Description: ${description}`));

        tBody.appendChild(trInfo);
        tBody.appendChild(trHide);

        moreLestBtn.addEventListener('click', () => {
            if (moreLestBtn.textContent === 'More Info'){
                moreLestBtn.textContent = 'Less Info';
                trHide.style = 'display: contents';
            } else {
                moreLestBtn.textContent = 'More Info';
                trHide.style = 'display: none';
            }
        });

        buyBtn.addEventListener('click', (event) => {
            trInfo.remove();
            trHide.remove();

            totalPrice += price;
            document.querySelector('.total-price').textContent = totalPrice.toFixed(2);
        });

    }
    function e(type, attributes, ...content) {
        const result = document.createElement(type);

        for (let [attr, value] of Object.entries(attributes || {})) {
            if (attr.substring(0, 2) == 'on') {
                result.addEventListener(attr.substring(2).toLocaleLowerCase(), value);
            } else {
                result[attr] = value;
            }
        }

        content = content.reduce((a, c) => a.concat(Array.isArray(c) ? c : [c]), []);

        content.forEach(e => {
            if (typeof e == 'string' || typeof e == 'number') {
                const node = document.createTextNode(e);
                result.appendChild(node);
            } else {
                result.appendChild(e);
            }
        });

        return result;
    }
}
 */
