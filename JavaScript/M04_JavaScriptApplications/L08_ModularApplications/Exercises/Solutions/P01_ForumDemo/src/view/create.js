import { createTopic } from '../api/data.js';
import { input } from '../common/input.js';
import { html } from '../lib.js';
import { createSubmtiHandler } from '../util.js';

const createTemplate = (onSubmit, errorMsg, errors, values) => html`
<div class="drop main">
    <header>
        <h1>Create New Topic</h1>
    </header>
    <form @submit=${onSubmit}>
        ${errorMsg ? html`<p class="error-msg">${errorMsg}</p>` : null}
        ${input('Topic Title', 'text', 'title', values.title, errors.title)}
        ${input('Content', 'textarea', 'content', values.content, errors.content)}
        <div class="center">
            <input class="action" type="submit" value="Publish Topic">
        </div>
    </form>
</div>`;

export function createPage(ctx) {
    update();

    function update(errorMsg = '', errors = {}, values = {}) {
        ctx.render(createTemplate(
            createSubmtiHandler(onSubmit, 'title', 'content'),
            errorMsg,
            errors,
            values
        ));
    }

    async function onSubmit(data) {
        try {
            const missing = Object.entries(data).filter(([k, v]) => v == '');
            if (missing.length > 0) {
                const errors = missing.reduce((a, [k]) => Object.assign(a, { [k]: true }), {});
                throw {
                    error: new Error('All fields are required!'),
                    errors
                };
            }

            const result = await createTopic(data);
            ctx.page.redirect('/topic/' + result._id);

        } catch (err) {
            const message = err.message || err.error.message;
            update(message, err.errors, data);
        }
    }
}