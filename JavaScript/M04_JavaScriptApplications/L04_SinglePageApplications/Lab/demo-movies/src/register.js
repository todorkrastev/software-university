import { showSection } from './dom.js';
import { showHomePage } from './home.js';
import { updateUserNav } from './app.js';

const section = document.getElementById('registerSection');
section.remove();
const form = section.querySelector('form');
form.addEventListener('submit', onSubmit);


export function showRegisterPage() {
    showSection(section);
}

async function onSubmit(event) {
    event.preventDefault();
    const formData = new FormData(form);

    const email = formData.get('email').trim();
    const password = formData.get('password').trim();
    const repass = formData.get('repass').trim();

    if (password != repass) {
        alert('Passwords don\'t match!');
        return;
    }

    try {
        const res = await fetch('http://localhost:3030/users/register', {
            method: 'post',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ email, password })
        });

        if (res.ok != true) {
            const error = await res.json();
            throw new Error(error.message);
        }

        const data = await res.json();
        const userData = {
            username: data.username,
            id: data._id,
            token: data.accessToken
        };
        sessionStorage.setItem('userData', JSON.stringify(userData));

        updateUserNav();
        showHomePage();
    } catch (err) {
        alert(err.message);
    }
}