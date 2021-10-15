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
