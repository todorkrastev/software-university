const baseUrl = `http://localhost:3030/jsonstore/phonebook`;
const inputPerson = document.getElementById('person');
const inputPhone = document.getElementById('phone');


function createLi({ person, phone, _id }) {
    const e = document.createElement('li');
    e.id = _id;
    e.innerHTML = `${person}: ${phone}`;
    const deleteBtn = document.createElement('button');
    deleteBtn.innerHTML = 'Delete';
    deleteBtn.className = 'remove';

    e.appendChild(deleteBtn);

    return e;
}

async function createData() {
    let [person, phone] = [
        inputPerson.value, inputPhone.value
    ];

    const response = await fetch(baseUrl, {
        method: 'post',
        headers: { 'content-type': 'application/json' },
        body: JSON.stringify({ person, phone })
    });

    inputPerson.value = '';
    inputPhone.value = '';

    return await response.json();
}

async function getData(url) {
    const response = await fetch(url);
    const data = await response.json();

    return Object.values(data);
}

function displayData(data) {
    const output = document.getElementById('phonebook');
    output.innerHTML = '';
    data.forEach(x => output.appendChild(createLi(x)));
}

async function deleteData(e, id) {
    const response = await fetch(`${baseUrl}/${id}`, {
        method: 'delete'
    });

    e.outerHTML = '';
}

function attachEvents() {
    document.addEventListener('click', e => {
        if (e.target.tagName === 'BUTTON') {
            const actions = {
                btnLoad: async () => displayData(await getData(baseUrl)),
                btnCreate: async () => {
                    await createData();
                    displayData(await getData(baseUrl));
                },
                remove: () => deleteData(e.target.parentNode, e.target.parentNode.id),
            };

            e.target.id ? actions[e.target.id]() : actions[e.target.className]();
        }
    })
}

attachEvents();



// second option


// function attachEvents() {
//     document.getElementById('btnLoad').addEventListener('click', load);
//     document.getElementById('btnCreate').addEventListener('click', create);

//     async function load() {
//         const response = await fetch('http://localhost:3030/jsonstore/phonebook');
//         const data = await response.json();
//         const ul = document.querySelector('#phonebook');
//         ul.innerHTML = '';

//         Object.values(data).forEach(value => {
//             let li = e('li', { id: value._id }, `${value.person}: ${value.phone}`);
//             let button = e('button', {}, 'Delete');
//             li.appendChild(button);
//             ul.appendChild(li);

//             button.addEventListener('click', async (event) => {
//                 const entryId = event.target.parentNode.id;
//                 await fetch('http://localhost:3030/jsonstore/phonebook/' + entryId, {
//                     method: 'delete'
//                 });
//                 load();
//             });
//         });
//     }

//     async function create() {
//         const personInput = document.querySelector('#person').value;
//         const phoneInput = document.querySelector('#phone').value;

//         await fetch('http://localhost:3030/jsonstore/phonebook', {
//             method: 'post',
//             headers: { 'Content-Type': 'application/' },
//             body: JSON.stringify({
//                 person: personInput,
//                 phone: phoneInput
//             })
//         });
//         document.querySelector('#person').value = '';
//         document.querySelector('#phone').value = '';
//     }

// }

// attachEvents();

// function e(type, attributes, ...content) {
//     const result = document.createElement(type);

//     for (let [attr, value] of Object.entries(attributes || {})) {
//         if (attr.substring(0, 2) == 'on') {
//             result.addEventListener(attr.substring(2).toLocaleLowerCase(), value);
//         } else {
//             result[attr] = value;
//         }
//     }

//     content = content.reduce((a, c) => a.concat(Array.isArray(c) ? c : [c]), []);

//     content.forEach(e => {
//         if (typeof e == 'string' || typeof e == 'number') {
//             const node = document.createTextNode(e);
//             result.appendChild(node);
//         } else {
//             result.appendChild(e);
//         }
//     });

//     return result;
// }



// third option


// function attachEvents() {
//     document.getElementById('btnLoad').addEventListener('click', loadContacts);
//     document.getElementById('btnCreate', onCreate);

//     list.addEventListener('click', onDelete);
//     loadContacts();
// }

// const list = document.getElementById('phonebook');
// const personInput = document.getElementById('person');
// const phoneInput = document.getElementById('phone');

// attachEvents();

// async function onDelete(event) {
//     const id = event.target.dataset.id;
//     if (id != undefined) {
//         await deleteContact(id);
//         event.target.parentElement.remove();
//     }
// }

// async function onCreate() {
//     const person = personInput.value;
//     const phone = phoneInput.value;
//     const contact = { person, phone };

//     const result = await createContact(contact);

//     list.appendChild(createItem(result));
// }

// async function loadContacts() {
//     const res = await fetch('http://localhost:3030/jsonstore/phonebook');
//     const data = await res.json();

//     list.replaceChildren(...Object.values(data).map(createItem));

// }

// function createItem(contact) {
//     const liElement = document.createElement('li');
//     liElement.innerHTML = `${contact.person}: ${contact.phone} <button data-id="${contact._id}>Delete</button>`;
//     return liElement;
// }

// async function createContact(contact) {
//     const res = await fetch('http://localhost:3030/jsonstore/phonebook', {
//         method: 'post',
//         headers: {
//             'Content-Type': 'application/json'
//         },
//         body: JSON.stringify(contact)
//     });
//     const result = await res.json();

//     return result;
// }

// async function deleteContact(id) {
//     const res = await fetch('http://localhost:3030/jsonstore/phonebook' + id, {
//         method: 'delete'
//     });
//     const result = await res.json();

//     return result;
// }
