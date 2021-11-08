let userData = null;
window.addEventListener('DOMContentLoaded', () => {
    userData = JSON.parse(sessionStorage.getItem('userData'));
    if (userData != null) {
        document.getElementById('guest').style.display = 'none';
        document.querySelector('#addForm .add').disabled = false;
        document.getElementById('logout').addEventListener('click', logout)
    }
    else {
        document.getElementById('user').style.display = 'none';
    }
    document.querySelector('.load').addEventListener('click', loadData)
    document.getElementById('addForm').addEventListener('submit', addCatch)
    document.getElementById('catches').addEventListener('click', invokeHandler);
})


function logout() {
    fetch('http://localhost:3030/users/logout', {
        method: 'get',
        headers: {
            'Content-Type': 'application/json',
            'X-Authorization': userData.token
        }
    });

    sessionStorage.removeItem('userData');
    window.location = './index.html';
}

function invokeHandler(event) {
    if (event.target.textContent == 'Update') {
        updateCatch(event);
    } else if (event.target.textContent == 'Delete') {
        deleteCatch(event);
    }
}

async function updateCatch(event) {
    const [angler, weight, species, location, bait, captureTime] = event.target.parentNode.querySelectorAll('input');
    const id = event.target.getAttribute('data-id');
    const token = userData.token;

    try {
        const response = await fetch('http://localhost:3030/data/catches/' + id, {
            method: 'put',
            headers: {
                'Content-Type': 'application/json',
                'X-Authorization': token
            },
            body: JSON.stringify({
                angler: angler.value, weight: weight.value, species: species.value,
                location: location.value, bait: bait.value, 'captureTime ': captureTime.value
            })
        });

        if (response.ok != true) {
            const error = await response.json();
            throw new Error(error.message);
        }
    }
    catch (err) {
        alert(err.message);
    }
}

async function deleteCatch(event) {
    const id = event.target.getAttribute('data-id');
    const token = userData.token;

    try {
        const response = await fetch('http://localhost:3030/data/catches/' + id, {
            method: 'delete',
            headers: { 'X-Authorization': token }
        });

        if (response.ok != true) {
            const error = await response.json();
            throw new Error(error.message);
        }
        loadData();
    }
    catch (err) {
        alert(err.message);
    }
}

async function addCatch(event) {
    event.preventDefault();
    if (!userData) {
        window.location = './login.html';
        return;
    }

    const formData = new FormData(event.target);

    const data = [...formData.entries()].reduce((a, [k, v]) => Object.assign(a, { [k]: v }), {});

    try {
        if (Object.values(data).some(x => x == '')) {
            throw new Error('All fields are required!')
        }

        const response = await fetch('http://localhost:3030/data/catches/', {
            method: 'post',
            headers: {
                'Content-Type': 'application/json',
                'X-Authorization': userData.token
            },
            body: JSON.stringify(data)
        });

        if (response.ok != true) {
            const error = await response.json();
            throw new Error(error.message);
        }

        loadData();
        event.target.reset();
    }
    catch (err) {
        alert(err.message);
    }
}

async function loadData() {
    const response = await fetch('http://localhost:3030/data/catches/');
    const data = await response.json();

    document.getElementById('catches').replaceChildren(...data.map(createDiv));

    function createDiv(data) {
        const isOwner = (userData && data._ownerId == userData.id);
        if (userData && data._ownerId == userData.id) {

        }
        const element = document.createElement('div');
        element.className = 'catch'
        element.innerHTML = `<label>Angler</label>
<input type="text" class="angler" value="${data.angler}"${!isOwner ? 'disabled' : ''}>
<label>Weight</label>
<input type="text" class="weight" value="${data.weight}"${!isOwner ? 'disabled' : ''}>
<label>Species</label>
<input type="text" class="species" value="${data.species}"${!isOwner ? 'disabled' : ''}>
<label>Location</label>
<input type="text" class="location" value="${data.location}"${!isOwner ? 'disabled' : ''}>
<label>Bait</label>
<input type="text" class="bait" value="${data.bait}"${!isOwner ? 'disabled' : ''}>
<label>Capture Time</label>
<input type="number" class="captureTime" value="${data.captureTime}"${!isOwner ? 'disabled' : ''}>
<button class="update" data-id="${data._id}"${!isOwner ? 'disabled' : ''}>Update</button>
<button class="delete" data-id="${data._id}"${!isOwner ? 'disabled' : ''}>Delete</button>`;
        return element;
    }
}
