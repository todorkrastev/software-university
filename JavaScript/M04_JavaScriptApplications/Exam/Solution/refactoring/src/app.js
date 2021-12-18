import { render } from '../node_modules/lit-html/lit-html.js';
import page from '../node_modules/page/page.mjs';

import { getUserData, removeUserData } from '/src/data/userData.js';
import { logoutUser } from '/src/data/requests.js';
import { homePage } from '/src/views/home.js';
import { loginPage } from './views/login.js';
import { registerPage } from './views/register.js';
import { catalogPage } from './views/catalog.js';
import { createPage } from './views/create.js';
import { detailsPage } from './views/details.js';
import { editPage } from './views/edit.js';
import { searchPage } from './views/search.js';

const main = document.getElementById('main-content');

page('/', decorateContext, homePage);
page('/login', decorateContext, loginPage);
page('/register', decorateContext, registerPage);
page('/catalog', decorateContext, catalogPage);
page('/create', decorateContext, createPage);
page('/details/:id', decorateContext, detailsPage);
page('/edit/:id', decorateContext, editPage);
page('/search', decorateContext, searchPage);


function decorateContext(ctx, next) {
    ctx.render = (content) => render(content, main);
    const userData = getUserData();
    userData !== null ? ctx.userData = userData : '';
    setupNav(userData);
    next();
}

function setupNav(userData) {
    if (userData !== null) {
        document.getElementById('user').style.display = 'inline-block';
        document.getElementById('guest').style.display = 'none';
    } else {
        document.getElementById('user').style.display = 'none';
        document.getElementById('guest').style.display = 'inline-block';
    }
}

document.getElementById('logoutBtn').addEventListener('click', () => {
    const token = getUserData().token;
    logoutUser(token);
    removeUserData();
    page.redirect('/');
});

page();