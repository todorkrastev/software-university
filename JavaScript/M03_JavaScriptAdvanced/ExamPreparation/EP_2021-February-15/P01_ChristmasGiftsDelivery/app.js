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