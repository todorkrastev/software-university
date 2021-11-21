import { html, render } from "./node_modules/lit-html/lit-html.js";
import { cats as catData } from './catSeeder.js';

const catCard = (cat) => html`
<li>
    <img src="./images/${cat.imageLocation}.jpg" width="250" height="250" alt="Card image cap">
    <div class="info">
        <button class="showBtn">Show status code</button>
        <div class="status" style="display: none" id="${cat.id}">
            <h4>Status Code: ${cat.statusCode}</h4>
            <p>${cat.statusMessage}</p>
        </div>
    </div>
</li>
<li></li>
`;

const root = document.getElementById('allCats');
render(html`<ul>${catData.map(catCard)}</ul>`, root);

root.addEventListener('click', (ev) => {
    if (ev.target.tagName == 'BUTTON') {
        const status = ev.target.parentNode.querySelector('.status');
        const nameBtn = ev.target.parentNode.querySelector('.showBtn');
        if (status.style.display == 'none') {
            status.style.display = 'block';
            nameBtn.textContent = 'Hide status code';
        } else {
            status.style.display = 'none';
            nameBtn.textContent = 'Show status code';
        }
    }
});
