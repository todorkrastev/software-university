function solve() {
    let movies = document.querySelector('#movies ul');
    let archive = document.querySelector('#archive ul');
    let buttons = document.querySelectorAll('button');
    let screenBtn = buttons[0];
    screenBtn.addEventListener('click', onScreen);

    function onScreen(event) {
        event.preventDefault();


        let inputs = {
            name: document.querySelectorAll('#container input')[0],
            hall: document.querySelectorAll('#container input')[1],
            price: document.querySelectorAll('#container input')[2]
        }

        if (inputs.name.value !== '' && inputs.hall.value !== '' && inputs.price.value !== `` &&
            isNaN(Number(inputs.price.value)) === false) {
            let archiveBtn = e('button', {}, 'Archive');
            let movie = e('li', {},
                e('span', {}, `${inputs.name.value.trim()}`),
                e('strong', {}, `Hall: ${inputs.hall.value.trim()}`),
                e('div', {},
                    e('strong', {}, `${Number(inputs.price.value.trim()).toFixed(2)}`),
                    e('input', { placeholder: 'Tickets Sold' }),
                    archiveBtn
                )
            );

            movies.appendChild(movie);

            archiveBtn.addEventListener('click', archiveHandler);

            inputs.name.value = '';
            inputs.hall.value = '';
            inputs.price.value = '';
        }
    }

    function archiveHandler() {
        let units = Number(this.parentElement.children[1].value);
        let ticketPrice = Number(this.parentElement.firstElementChild.textContent);

        if (isNaN(units) === false) {
            let deleteBtn = e('button', {}, 'Delete');
            let totalPrice = units * ticketPrice;

            let movie = e('li', {},
                e('span', {}, `${this.parentElement.parentElement.children[0].textContent}`),
                e('strong', {}, `Total amount: ${totalPrice.toFixed(2)}`),
                deleteBtn
            );

            archive.appendChild(movie);
            deleteBtn.addEventListener('click', deleteHandler);
            let clearBtn = buttons[1];
            clearBtn.addEventListener('click', clearHandler);
            this.parentElement.parentElement.remove();
        }
    }

    function clearHandler() {
        let parent = Array.from(this.parentElement.querySelectorAll('li'));
        parent.forEach(li => li.remove());
    }

    function deleteHandler() {
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