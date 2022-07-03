import * as api from '../api/data.js'

const loginSection = document.getElementById('loginSection');
loginSection.remove();
const form = loginSection.querySelector('form');
form.addEventListener('submit', onSubmit);
let ctx = null;


export function showLoginPage(ctxTarget) {
  ctx = ctxTarget;
  ctx.showSection(loginSection);
}

async function onSubmit(ev) {
  ev.preventDefault();
  const formData = new FormData(form);

  const email = formData.get('email').trim();
  const password = formData.get('password').trim();

  await api.login(email, password);
  form.reset();
  ctx.updateUserNav();
  ctx.goTo('home');
}