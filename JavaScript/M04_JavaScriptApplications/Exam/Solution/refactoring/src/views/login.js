import { html } from '../../node_modules/lit-html/lit-html.js';

import { loginUser } from '../data/requests.js';
import { saveUserData } from '../data/userData.js';


const template = (onSubmit) => html`
<section id="loginPage">
<form id="login" @submit=${onSubmit}>
    <fieldset>
        <legend>Login</legend>

        <label for="email" class="vhide">Email</label>
        <input id="email" class="email" name="email" type="text" placeholder="Email">

        <label for="password" class="vhide">Password</label>
        <input id="password" class="password" name="password" type="password" placeholder="Password">

        <button type="submit" class="login">Login</button>

        <p class="field">
            <span>If you don't have profile click <a href="#">here</a></span>
        </p>
    </fieldset>
</form>
</section>`;




export const loginPage = (ctx) => {
    ctx.render(template(onSubmit));

    async function onSubmit(e) {
        e.preventDefault();
        const formData = new FormData(e.target);
        const email = formData.get('email').trim();
        const password = formData.get('password').trim();

        if (email === '' || password === '') {
            return alert('All fields are required!');
        }

        const response = await loginUser({ email, password });
        saveUserData({ token: response.accessToken, email: response.email, id: response._id });
        ctx.page.redirect('/');
    }
}