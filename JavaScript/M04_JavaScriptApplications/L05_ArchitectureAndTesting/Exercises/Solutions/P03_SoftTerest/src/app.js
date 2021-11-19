import { showSection } from './dom.js';
import { showHomePage } from './views/home.js';
import { showCatalogPage } from './views/catalog.js';
import { showLoginPage } from './views/login.js';
import { showRegisterPage } from './views/register.js';
import { showCreatePage } from './views/create.js';
import { showDetailsPage } from './views/details.js';
import { logout } from './api/data.js';

const links = {
    'homeLink': 'home',
    'getStartedLink': 'home',
    'catalogLink': 'catalog',
    'loginLink': 'login',
    'registerLink': 'register',
    'createLink': 'create'
};

const views = {
    'home': showHomePage,
    'catalog': showCatalogPage,
    'login': showLoginPage,
    'register': showRegisterPage,
    'create': showCreatePage,
    'details': showDetailsPage
};

const nav = document.querySelector('nav');
nav.addEventListener('click', onNavigate);
document.getElementById('logoutBtn').addEventListener('click', async (ev) => {
    ev.preventDefault();
    await logout();
    updateNav();
    goTo('home');
})


const ctx = {
    goTo,
    showSection,
    updateNav
};

updateNav();
goTo('home');

function onNavigate(event) {
    const name = links[event.target.id];
    if (name) {
        event.preventDefault();
        goTo(name);
    }
}

function goTo(name, ...params) {
    const view = views[name];
    if (typeof view == 'function') {
        view(ctx, ...params);
    }
}

function updateNav() {
    const userData = JSON.parse(sessionStorage.getItem('userData'));
    if (userData != null) {
        [...nav.querySelectorAll('.user')].forEach(l => l.style.display = 'block');
        [...nav.querySelectorAll('.guest')].forEach(l => l.style.display = 'none');
    } else {
        [...nav.querySelectorAll('.user')].forEach(l => l.style.display = 'none');
        [...nav.querySelectorAll('.guest')].forEach(l => l.style.display = 'block');
    }
}