import { loadTopic } from './topic.js';

export async function loadHomePage() {
    const main = document.querySelector('main');
    const divNewTopic = document.querySelector('.new-topic-border');

    const response = await fetch('http://localhost:3030/jsonstore/collections/myboard/posts');
    const data = await response.json();


    main.innerHTML = '';

    const fragment = document.createDocumentFragment();
    Object.values(data).map(createDivElement).forEach(d => fragment.appendChild(d));

    main.appendChild(divNewTopic);
    main.appendChild(fragment);
}

function createDivElement(post) {
    const divTopic = document.createElement('div');
    divTopic.className = 'topic-container';
    divTopic.innerHTML = `<div class="topic-name-wrapper">
    <div class="topic-name">
    <input type="hidden" id="inputId" value="${post._id}">
        <a href="#" class="normal">
            <h2>${post.title}</h2>
        </a>
        <div class="columns">
            <div>
            <p>Date: <time>${post.time}</time></p>
                <div class="nick-name">
                    <p>Username: <span>${post.username}</span></p>
                </div>
            </div>
        </div>
    </div>
    </div>`;

    divTopic.addEventListener('click', (event) => {
        if (event.target.tagName == 'H2') {
            const id = event.target.parentNode.parentNode.querySelector('#inputId').value;
            loadTopic(id);
        }
    });

    return divTopic;
}