import { register } from "../api/data.js";

const registerSection = document.getElementById('registerSection');
registerSection.remove();
const form = registerSection.querySelector('form');
form.addEventListener('submit', onSubmit);
let ctx = null;

export function showRegisterPage(ctxTarget) {
  ctx = ctxTarget;
  ctx.showSection(registerSection);
}

async function onSubmit(ev) {
  ev.preventDefault();
  const formData = new FormData(form);

  const email = formData.get('email').trim();
  const password = formData.get('password').trim();
  const repass = formData.get('repass').trim();

  if (password != repass) {
    alert('Repeat password doesn\'t match');
    return;
  }
  
  await register(email, password);
  form.reset();
  ctx.updateUserNav();
  ctx.goTo('home');
}