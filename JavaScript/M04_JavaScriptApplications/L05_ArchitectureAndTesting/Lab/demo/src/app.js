import { logout } from "./api/data.js";
import { showCatalogPage } from "./views/catalog.js";
import { showAboutPage, showHomePage } from "./views/home.js";
import { showLoginPage } from "./views/login.js";
import { showRegisterPage } from "./views/register.js";
import { showSection } from './dom.js'

document.getElementById('logoutBtn').addEventListener('click', onLogout);
document.querySelector('nav').addEventListener('click', onNavigate);

const views = {
  'home': showHomePage,
  'catalog': showCatalogPage,
  'about': showAboutPage,
  'login': showLoginPage,
  'register': showRegisterPage
};

const links = {
  'homeBtn': 'home',
  'catalogBtn': 'catalog',
  'aboutBtn': 'about',
  'loginBtn': 'login',
  'registerBtn': 'register'
};

updateUserNav();

const ctx = {
  updateUserNav,
  goTo,
  showSection
};

//start on home page
goTo('home');

function onNavigate(ev) {
  if (ev.target.tagName == 'A') {
    const name = links[ev.target.id];
    if (name) {
      ev.preventDefault();
      goTo(name);
    }
  }
}

function goTo(name, ...params) {
  const view = views[name];
  if (typeof view == 'function') {
    view(ctx, ...params);
  }
}

export function updateUserNav() {
  const userData = JSON.parse(sessionStorage.getItem('userData'));
  if (userData != null) {
    document.getElementById('userNav').style.display = 'inline-block';
    document.getElementById('guestNav').style.display = 'none';
  } else {
    document.getElementById('userNav').style.display = 'none';
    document.getElementById('guestNav').style.display = 'inline-block';
  }
}

async function onLogout(ev) {
  ev.stopImmediatePropagation();

  await logout();

  updateUserNav();
  goTo('home');
}