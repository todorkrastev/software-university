window.addEventListener('load', solve);

function solve() {
    let receivedOrders = document.querySelector('#received-orders');
    let completedOrders = document.querySelector('#completed-orders');
    let submitBtn = document.querySelector('button');
    submitBtn.addEventListener('click', onSubmit);
    let clearBtn = document.querySelector('.clear-btn');
    clearBtn.addEventListener('click', clearBtnHandler);

    function onSubmit(event) {
        event.preventDefault();

        let productType = document.querySelector('#type-product');
        let description = document.querySelector('#description');
        let name = document.querySelector('#client-name');
        let phone = document.querySelector('#client-phone');

        if (description.value != '' && name.value != '' && phone.value != '') {
            let startBtn = e('button', { className: 'start-btn' }, 'Start repair');
            let finishBtn = e('button', { className: 'finish-btn', disabled: true }, 'Finish repair');

            let device = e('div', { className: 'container' },
                e('h2', {}, `Product type for repair: ${productType.value}`),
                e('h3', {}, `Client information: ${name.value.trim()}, ${phone.value.trim()}`),
                e('h4', {}, `Description of the problem: ${description.value.trim()}`),
                startBtn,
                finishBtn
            );

            receivedOrders.appendChild(device);

            startBtn.addEventListener('click', startBtnHandler);
            finishBtn.addEventListener('click', finishBtnHandler);

            productType.value = '';
            description.value = '';
            name.value = '';
            phone.value = '';
        }
    }

    function startBtnHandler() {
        this.disabled = true;
        this.nextElementSibling.disabled = false
    }

    function finishBtnHandler() {
        let device = e('div', { className: 'container' },
            e('h2', {}, `${this.parentElement.children[0].textContent}`),
            e('h3', {}, `${this.parentElement.children[1].textContent}`),
            e('h4', {}, `${this.parentElement.children[2].textContent}`)
        )

        completedOrders.appendChild(device);

        this.parentElement.remove();
    }

    function clearBtnHandler() {
        Array.from(this.parentElement.querySelectorAll('.container'))
            .forEach(d => d.remove());
        console.log(completedOrders);
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
