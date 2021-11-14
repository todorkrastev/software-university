import { createNewTopic } from './topic.js';
import { loadHomePage } from './home.js';

function addEvents() {
    document.querySelector('.public').addEventListener('click', createNewTopic);

    document.querySelector('.cancel').addEventListener('click', (event) => {
        const form = event.target.parentNode.parentNode;
        form.reset();
    });
}

loadHomePage();
addEvents();