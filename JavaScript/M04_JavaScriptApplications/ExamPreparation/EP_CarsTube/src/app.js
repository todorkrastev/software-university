import { logout } from './api/data.js';
import { page, render } from './lib.js';
import { getUserData } from './util.js';
// import { createPage } from './views/create.js';
// import { detailsPage } from './views/details.js';
// import { editPage } from './views/edit.js';
// import { homePage } from './views/home.js';
// import { loginPage } from './views/login.js';
// import { myBooksPage } from './views/my-books.js';
// import { registerPage } from './views/register.js';

// DEBUG


import * as api from './api/api.js';
import { loginPage } from './views/login.js';
import { registerPage } from './views/register.js';
import { homePage } from './views/home.js';
import { catalogPage } from './views/catalogue.js';
import { createPage } from './views/create.js';
import { detailsPage } from './views/details.js';
import { editPage } from './views/edit.js';
import { myCarsPage } from './views/my-cars.js';
window.api = api;


const root = document.getElementById('site-content');
document.getElementById('logoutBtn').addEventListener('click', onLogout);

page(decorateContext);
page('/', homePage);
page('/login', loginPage);
page('/register', registerPage);
page('/catalogue', catalogPage);
page('/create', createPage);
page('/details/:id', detailsPage);
page('/edit/:id', editPage);
page('/my-cars', myCarsPage);

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
        document.getElementById('profile').style.display = '';
        document.getElementById('guest').style.display = 'none';
        document.querySelector('#user-welcoming').textContent = `Welcome ${userData.username}`;
    } else {
        document.getElementById('profile').style.display = 'none';
        document.getElementById('guest').style.display = '';
    }
}

function onLogout() {
    logout();
    updateUserNav();
    page.redirect('/');
}