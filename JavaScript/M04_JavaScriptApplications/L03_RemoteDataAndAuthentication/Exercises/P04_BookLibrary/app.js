function bookLibrary() {
    document.querySelector('#loadBooks').addEventListener('click', onLoad);
    document.querySelector('form button').addEventListener('click', onSubmit);
}
bookLibrary();


async function onLoad() {
    document.querySelectorAll('form input')[0].value = '';
    document.querySelectorAll('form input')[1].value = '';

    document.querySelector('tBody').innerHTML = '';
    const response = await fetch('http://localhost:3030/jsonstore/collections/books');
    const data = await response.json();
    let tBody = document.querySelector('tBody');

    Object.entries(data).forEach(([key, value]) => {
        let elements = e('tr', { id: key },
            e('td', {}, value.author),
            e('td', {}, value.title),
            e('td', {},
                e('button', { id: 'edit' }, 'Edit'),
                e('button', { id: 'delete' }, 'Delete'))
        );
        tBody.appendChild(elements);

        elements.querySelector('#edit').addEventListener('click', async (event) => {
            event.preventDefault();
            if (document.querySelector('#save')) {
                document.querySelector('#save').remove();
            }
            const currentElement = event.target.parentNode.parentNode;
            const currentAuthor = currentElement.children[0].textContent;
            const currentTitle = currentElement.children[1].textContent;
            const id = currentElement.id;

            document.querySelectorAll('form input')[0].value = currentTitle;
            document.querySelectorAll('form input')[1].value = currentAuthor;

            document.querySelector('form h3').textContent = 'Edit FORM';
            document.querySelector('form button').style.display = 'none';
            document.querySelector('form').appendChild(e('button', { id: 'save' }, 'Save'));
            const saveButton = document.querySelector('#save');

            saveButton.addEventListener('click', async () => {
                if (currentAuthor == '' && currentTitle == '') {
                    return alert('All fields are required');
                }
                await fetch('http://localhost:3030/jsonstore/collections/books/' + id, {
                    method: 'put',
                    headers: { 'Content-Type': 'application/' },
                    body: JSON.stringify({
                        author: document.querySelectorAll('form input')[0].value,
                        title: document.querySelectorAll('form input')[1].value
                    })
                });

                document.querySelector('form button').style.display = 'block';
                saveButton.remove();
            });
        });

        elements.querySelector('#delete').addEventListener('click', async (event) => {
            event.preventDefault();
            const currentElement = event.target.parentNode.parentNode;
            const id = currentElement.id;
            const confirmed = confirm('Are you sure you want to delete this book?');
            if (confirmed) {
                await fetch('http://localhost:3030/jsonstore/collections/books/' + id, {
                    method: 'delete'
                });
                onLoad();
            }

        });
    });
}


async function onSubmit(event) {
    event.preventDefault();
    const [author, title] = Array.from(document.querySelectorAll('form input'));

    if (author.value == '' || title.value == '') {
        return alert('All fields are required');
    }

    const response = await fetch('http://localhost:3030/jsonstore/collections/books', {
        method: 'post',
        headers: { 'Content-Type': 'application/' },
        body: JSON.stringify({
            author: author.value,
            title: title.value,
        })
    });
    if (response.ok == false) {
        return alert('Error');
    }

    document.querySelectorAll('form input')[0].value = '';
    document.querySelectorAll('form input')[1].value = '';
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