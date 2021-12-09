function solution() {

    let input = document.querySelector('input');
    let addButton = document.querySelector('button');
    let gifts = document.querySelector('.container > section:nth-of-type(2) ul');
    let sentGifts = document.querySelector('.container > section:nth-of-type(3) ul');
    let discardedGifts = document.querySelector('.container > section:nth-of-type(4) ul');

    addButton.addEventListener('click', addGift);

    function addGift() {

        if (input.value.trim()) {

            let sendButton = document.createElement('button');
            sendButton.setAttribute('id', 'sendButton');
            sendButton.textContent = 'Send';

            let discardButton = document.createElement('button');
            discardButton.setAttribute('id', 'discardButton');
            discardButton.textContent = 'Discard';

            let item = document.createElement('li');
            item.setAttribute('class', 'gift');
            item.textContent = input.value;
            item.appendChild(sendButton);
            item.appendChild(discardButton);

            gifts.appendChild(item);

            Array.from(gifts.querySelectorAll('li'))
                .sort((a, b) => a.textContent.localeCompare(b.textContent))
                .forEach(item => gifts.appendChild(item));

            input.value = null;

            [sendButton, discardButton].forEach(btn => btn.addEventListener('click', manageGifts));
        }
    }

    function manageGifts(btn) {

        let item = btn.target.parentNode;
        item.lastElementChild.remove();
        item.lastElementChild.remove();

        if (btn.target.textContent === 'Send') {
            sentGifts.appendChild(item);
        } else {
            discardedGifts.appendChild(item);
        }
    }
}



// second option

/*
function solution() {
    let input = document.querySelector('.card input');
    let cards = document.querySelectorAll('.card ul');
    let listOfGifts = cards[0];
    let sentGifts = cards[1];
    let discardedGifts = cards[2];

    let addBtn = document.querySelector('button');
    addBtn.addEventListener('click', onClick);

    function onClick(event) {
        event.preventDefault();

        let sendBtn = e('button', { id: 'sendButton' }, 'Send');
        let discardBtn = e('button', { id: 'discardButton' }, 'Discard');

        let li = e('li', { className: 'gift' },
            `${input.value.trim()}`,
            sendBtn,
            discardBtn);
        listOfGifts.appendChild(li);
        let sortedList = Array.from(listOfGifts.querySelectorAll('li'));
        sortedList
            .sort((a, b) => a.textContent.localeCompare(b.textContent))
            .forEach(li => listOfGifts.appendChild(li));

        sendBtn.addEventListener('click', sendHandler);
        discardBtn.addEventListener('click', discardHandler);

        input.value = '';
    }

    function discardHandler() {
        let item = this.parentElement.textContent.replace('SendDiscard', '')
        discardedGifts.appendChild(e('li', { className: 'gift'}, `${item}`));
        this.parentElement.remove();
    }

    function sendHandler() {
        let item = this.parentElement.textContent.replace('SendDiscard', '');

        sentGifts.appendChild(e('li', { className: 'gift' }, `${item}`));
        this.parentElement.remove();

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



// third option


// function solution() {
//     const cardLists = document.querySelectorAll(`.container section ul`);
//     const inputField = document.querySelector('input');

//     function giftTemplFactory(moved, name) {
//         const li = document.createElement('li');

//         li.className = 'gift';
//         li.innerHTML =
//             `${name}${moved
//                 ? `<button id="sendButton">Send</button><button id="discardButton">Discard</button>`
//                 : ''}`;

//         return li;
//     }

//     const appendToSection = (s, e) => {
//         s.appendChild(giftTemplFactory(false, e.parentNode.childNodes[0].textContent));
//         e.parentNode.outerHTML = '';
//     }

//     document.addEventListener('click', (e) => {
//         if (e.target.tagName === 'BUTTON') {
//             const action = e.target.id;

//             const actions = {
//                 '': () => {
//                     const listOfGifts = cardLists[0];
//                     const gifts = Array.from(listOfGifts.children);

//                     gifts.push(giftTemplFactory(true, inputField.value));
//                     gifts.sort((a, b) => a.innerHTML.localeCompare(b.innerHTML));
//                     gifts.forEach(gift => listOfGifts.appendChild(gift));
//                     inputField.value = '';

//                 },
//                 'sendButton': () => appendToSection(cardLists[1], e.target),
//                 'discardButton': () => appendToSection(cardLists[2], e.target),
//             }

//             actions[action]();
//         }
//     })
// }