window.addEventListener('DOMContentLoaded', () => {
    const form = document.querySelector('form');
    form.addEventListener('submit', onLogin)
    if (!sessionStorage.hasOwnProperty('userData')) {
        document.getElementById('user').style.display = 'none';
    }
})

async function onLogin(event) {
    event.preventDefault();
    const formData = new FormData(event.target);

    const email = formData.get('email');
    const password = formData.get('password');

    try {
        const res = await fetch('http://localhost:3030/users/login',
        {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ email, password })
        });
        
        if (res.ok != true) {
            const error = await res.json();
            throw new Error(error.message)
        }

        const data = await res.json();
        const userData = {
            email: data.email,
            id: data._id,
            token: data.accessToken
        };
        sessionStorage.setItem('userData', JSON.stringify(userData));
        window.location = './index.html';
    } catch (err) {
        alert(err.message)
    }
}