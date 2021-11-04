function eFactory(tag, className = '', content = '') {
    const e = document.createElement(tag);
    e.className = className;
    e.textContent = content;

    return e;
}

function template({ _id, title }) {
    const wrapper = eFactory('div', 'accordion');
    const headDiv = eFactory('div', 'head');
    const titleSpan = eFactory('span', '', title);
    const btn = eFactory('button', 'button', 'More');
    const extraDiv = eFactory('div', 'extra');
    extraDiv.style.display = 'none';
    const contentParagraph = eFactory('p');
    btn.id = _id;

    headDiv.append(titleSpan, btn);
    extraDiv.appendChild(contentParagraph);
    wrapper.append(headDiv, extraDiv);

    btn.addEventListener('click', async () => {
        if (extraDiv.style.display === 'none') {
            const data = await fetch(`http://localhost:3030/jsonstore/advanced/articles/details/${_id}`);
            const desData = await data.json();
            btn.textContent = 'Less';
            extraDiv.style.display = 'block';
            contentParagraph.textContent = desData.content;
        } else {
            btn.textContent = 'More';
            extraDiv.style.display = 'none';
        }
    })

    return wrapper;
}

async function solution() {
    const output = document.getElementById('main');
    const titles = await fetch('http://localhost:3030/jsonstore/advanced/articles/list');
    const desTitles = await titles.json();

    desTitles.forEach(x => output.appendChild(template(x)));
}

document.addEventListener('DOMContentLoaded', solution);



// second option


// async function solution() {
//     const url = 'http://localhost:3030/jsonstore/advanced/articles/list';

//     let data;
//     try {
//         const response = await fetch(url);
//         if (response.status !== 200) {
//             throw new Error(response.message);
//         }
//         data = await response.json();
//     } catch (error) {
//         alert(error.message);
//     }

//     const main = document.querySelector('#main');

//     Object.values(data).map(value => {
//         main.appendChild(createElements(value._id, value.title));
//     });
// }

// window.addEventListener('load', () => {
//     solution();
// });

// function createElements(id, title) {
//     const elements = e('div', { className: 'accordion' },
//         e('div', { className: 'head' },
//             e('span', {}, title),
//             e('button', { className: 'button', id: id }, 'MORE')),
//         e('div', { className: 'extra' }));

//     elements.querySelector('.button').addEventListener('click', getDetails);

//     return elements;
// }

// async function getDetails(event) {
//     const id = event.target.id;
//     let url = `http://localhost:3030/jsonstore/advanced/articles/details/${id}`;
//     const response = await fetch(url);
//     const data = await response.json();

//     let divExtra = event.target.parentNode.parentNode.querySelector('.extra');
//     let p = e('p', {}, data.content);
//     if (event.target.textContent === 'MORE') {
//         divExtra.appendChild(p);
//         divExtra.style.display = 'block';
//         event.target.textContent = 'LESS';
//     } else {
//         event.target.textContent = 'MORE';
//         divExtra.style.display = 'none';
//         event.target.parentNode.parentNode.querySelector('.extra p').remove();
//     }
// }

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
