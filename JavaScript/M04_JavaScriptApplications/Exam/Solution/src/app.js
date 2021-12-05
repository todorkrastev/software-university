import { logout } from './api/data.js';
import { page, render } from './lib.js';
import { getUserData } from './util.js';

// import { detailsPage } from './views/details.js';
// import { editPage } from './views/edit.js';
// import { myCarsPage } from './views/my-cars.js';



import * as api from './api/api.js';
import { loginPage } from './views/login.js';
import { homePage } from './views/home.js';
import { registerPage } from './views/register.js';
import { catalogPage } from './views/catalog.js';
import { createPage } from './views/create.js';
import { detailsPage } from './views/details.js';
import { editPage } from './views/edit.js';
window.api = api;


const root = document.getElementById('main-content');
document.getElementById('logoutBtn').addEventListener('click', onLogout);

page(decorateContext);
page('/', homePage);
page('/login', loginPage);
page('/register', registerPage);
page('/catalog', catalogPage);
page('/create', createPage);
page('/details/:id', detailsPage);
page('/edit/:id', editPage);
// page('/my-cars', myCarsPage);

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
        document.getElementById('profile').style.display = 'inline';
        document.getElementById('guest').style.display = 'none';
    } else {
        document.getElementById('profile').style.display = 'none';
        document.getElementById('guest').style.display = 'inline';
    }
}

function onLogout() {
    logout();
    updateUserNav();
    page.redirect('/');
}