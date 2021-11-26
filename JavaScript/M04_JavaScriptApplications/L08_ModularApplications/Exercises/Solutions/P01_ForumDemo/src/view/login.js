import { login } from '../api/api.js';
import { html } from '../lib.js';
import { createSubmtiHandler } from '../util.js';

const loginTemplate = (onSubmit, errorMsg, email) => html`
<div class="narrow drop center">
    <header>
        <h1>Login</h1>
    </header>
    <form @submit=${onSubmit}>
        ${errorMsg ? html`<p class="error-msg">${errorMsg}</p>` : null}
        <label><span>Email</span><input type="text" name="email" .value=${email}></label>
        <label><span>Password</span><input type="password" name="password"></label>
        <input class="action" type="submit" value="Sign In">
    </form>
</div>`;

export function loginPage(ctx) {
    update();

    function update(errorMsg = '', email = '') {
        ctx.render(loginTemplate(
            createSubmtiHandler(onSubmit, 'email', 'password'),
            errorMsg,
            email
        ));
    }

    async function onSubmit(data) {
        try {
            await login(data.email, data.password);
            ctx.updateUserNav();
            ctx.page.redirect('/topics');
        } catch (err) {
            const message = err.message || err.error.message;
            update(message, data.email);
        }
    }
}