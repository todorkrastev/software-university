import { logout } from './api/data.js';
import { page, render } from './lib.js';
import { getUserData } from './util.js';

import { homePage } from './views/home.js';
import { loginPage } from './views/login.js';
import { registerPage } from './views/register.js';
import { createPage } from './views/create.js';
import { catalogPage } from './views/catalogue.js';
import { detailsPage } from './views/details.js';
import { editPage } from './views/edit.js';
import { myMemesPage } from './views/my-memes.js';

/*
DEBUG
import * as api from './api/api.js';
window.api = api;
*/

const root = document.getElementById('site-content');
document.getElementById('logoutBtn').addEventListener('click', onLogout);

page(decorateContext);
page('/', homePage);
page('/login', loginPage);
page('/register', registerPage);
page('/create', createPage);
page('/all-memes', catalogPage);
page('/details/:id', detailsPage);
page('/edit/:id', editPage);
page('/profile', myMemesPage);

updateUserNav();
page.start();


function decorateContext(ctx, next) {
    ctx.render = (content) => render(content, root);
    ctx.updateUserNav = updateUserNav;
    next();
}

function updateUserNav() {
    const userData = getUserData();
    if (userData) {
        document.getElementById('user').style.display = 'block';
        document.getElementById('guest').style.display = 'none';
        document.querySelector('.profile span').textContent = `Welcome, ${userData.email}`;
    } else {
        document.getElementById('user').style.display = 'none';
        document.getElementById('guest').style.display = 'block';
    }
}

function onLogout() {
    logout();
    updateUserNav();
    page.redirect('/');
}
