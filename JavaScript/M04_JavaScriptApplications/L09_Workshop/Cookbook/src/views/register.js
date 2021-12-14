import { register } from '../api/user.js';
import { html } from '../lib.js';
import { createSubmitHandler } from '../util.js';
import { errorMsg, field } from './common.js';


const registerTemplate = (onSubmit, errors, data) => html`
<section id="register">
    <article>
        <h2>Register</h2>
        <form @submit=${onSubmit} id="registerForm">
            ${errorMsg(errors)}

            ${field({ label: 'Username', name: 'username', value: data.username, error: errors.username })}
            ${field({ label: 'E-mail', name: 'email', value: data.email, error: errors.email })}
            ${field({ label: 'Password', type: 'password', name: 'password', value: data.password, error:
            errors.password })}
            ${field({ label: 'Repeat', type: 'password', name: 'repass', value: data.repass, error: errors.repass })}
            <input type="submit" value="Register">
        </form>
    </article>
</section>`;

export function registerPage(ctx) {
    update();

    function update(errors = {}, data = {}) {
        ctx.render(registerTemplate(createSubmitHandler(onSubmit, 'username', 'email', 'password', 'repass'), errors, data));
    }

    async function onSubmit(data, event) {
        try {
            const missing = Object.entries(data).filter(([k, v]) => v == '');

            if (missing.length > 0) {
                throw missing.reduce((a, [k]) => Object.assign(a, { [k]: true }), { message: 'Please fill all fields!' }); 
            }
            if (data.password != data.repass) {
                throw {
                    message: 'Passwords don\'t match!',
                    password: true,
                    repass: true
                };
            }

            await register(data.username, data.email, data.password);
            event.target.reset();
            ctx.updateSession();
            ctx.updateUserNav();
            ctx.page.redirect('/catalog');
        } catch (err) {
            if (err.code == 202) {
                err.username = true;
            } else if (err.code == 203) {
                err.email = true;
            }
            update(err, { username: data.username, email: data.email });
        }
    }
}