import { html } from '../../node_modules/lit-html/lit-html.js';

import { registerUser } from '../data/requests.js';
import { saveUserData } from '../data/userData.js';

const template = (onSubmit) => html`
<section id="registerPage">
<form id="register" @submit=${onSubmit}>
    <fieldset>
        <legend>Register</legend>

        <label for="email" class="vhide">Email</label>
        <input id="email" class="email" name="email" type="text" placeholder="Email">

        <label for="password" class="vhide">Password</label>
        <input id="password" class="password" name="password" type="password" placeholder="Password">

        <label for="conf-pass" class="vhide">Confirm Password:</label>
        <input id="conf-pass" class="conf-pass" name="conf-pass" type="password" placeholder="Confirm Password">

        <button type="submit" class="register">Register</button>

        <p class="field">
            <span>If you already have profile click <a href="#">here</a></span>
        </p>
    </fieldset>
</form>
</section>`;




export const registerPage = (ctx) => {
    ctx.render(template(onSubmit));

    async function onSubmit(e) {
        e.preventDefault();
        const formData = new FormData(e.target);
        const email = formData.get('email').trim();
        const password = formData.get('password').trim();
        const repeatPass = formData.get('conf-pass').trim();

        if (email === '' || password === '') {
            return alert('All fields are required!');
        }

        if (password !== repeatPass) {
            return alert('Passwords don`t match!');
        }

        const response = await registerUser({ email, password });
        saveUserData({ token: response.accessToken, email: response.email, id: response._id });
        ctx.page.redirect('/');
    }
}