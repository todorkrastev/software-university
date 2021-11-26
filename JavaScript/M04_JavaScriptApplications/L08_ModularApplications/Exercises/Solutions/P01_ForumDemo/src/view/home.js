import { html, until } from '../lib.js';
import { getTopicCount } from '../api/data.js';

const homeTemplate = (countPromise) => html`
<h1>Scripters Home</h1>
<div class="splash drop">
    <p>Welcome to Scripters Forum!</p>
    <div>
        <a href="/topics">Browse ${until(countPromise, 'topics')}</a>
    </div>
</div>`;

export function homePage(ctx) {
    ctx.render(homeTemplate(loadHome()));
}

async function loadHome() {
    const count = await getTopicCount();

    return `${count} topic`;
}