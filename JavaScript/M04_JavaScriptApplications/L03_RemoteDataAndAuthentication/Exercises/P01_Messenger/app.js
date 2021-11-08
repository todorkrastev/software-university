function attachEvents() {
    const url = 'http://localhost:3030/jsonstore/messenger';

    const clearInputs = (arr) => arr.forEach(x => x.value = '');

    document.getElementById(`submit`).addEventListener('click', async () => {
        const author = document.querySelector('#controls > input[type=text]:nth-child(2)');
        const content = document.querySelector('#controls > input[type=text]:nth-child(5)');
        const rawData = {
            author: author.value,
            content: content.value
        };

        const response = await fetch(url, {
            method: 'post',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(rawData)
        });

        clearInputs([author, content]);

        return response;
    })

    document.getElementById('refresh').addEventListener('click', async () => {
        const data = await fetch(url);
        const deserialized = await data.json();

        document.getElementById(`messages`).value =
            Object.values(deserialized)
                .map(x => `${x.author}: ${x.content}`)
                .join('\n');
    })
}

attachEvents();



// second option


// function attachEvents() {
//     document.getElementById('refresh').addEventListener('click', loadMessages);
//     document.getElementById('submit').addEventListener('click', onSubmit);
//     loadMessages();
// }

// const authorInput = document.querySelector('[name="author"]');
// const contentInput = document.querySelector('[name="content"]');
// const list = document.getElementById('messages');

// attachEvents();

// async function onSubmit() {
//     const author = authorInput.value;
//     const content = contentInput.value;

//     const result = await createMessage({ author, content });

//     contentInput.value = '';
//     list.value += '\n' + `${author}: ${content}`;

// }

// async function loadMessages() {
//     const url = 'http://localhost:3030/jsonstore/messenger';
//     const res = await fetch(url);
//     const data = await res.json();

//     const messages = Object.values(data);

//     list.value = messages.map(m => `${m.author}: ${m.content}`).join('\n');
// }

// async function createMessage(message) {
//     const url = 'http://localhost:3030/jsonstore/messenger';

//     const options = {
//         method: 'post',
//         headers: {
//             'Content-Type': 'application/json'
//         },
//         body: JSON.stringify(message)
//     };

//     const res = await fetch(url, options);
//     const result = await res.json();

//     return result;
// }
