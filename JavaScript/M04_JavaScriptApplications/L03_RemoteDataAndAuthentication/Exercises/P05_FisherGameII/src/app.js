let userData = null;

window.addEventListener('DOMContentLoaded', () => {
    userData = JSON.parse(sessionStorage.getItem('userData'));
    if (userData != null) {
        document.getElementById('guest').style.display = 'none';
        document.querySelector('#addForm .add').disabled = false;
    } else {
        document.getElementById('user').style.display = 'none';
    }

    document.querySelector('.load').addEventListener('click', loadData)
    document.getElementById('addForm').addEventListener('submit', onCreateSubmit)
    const catches = document.getElementById('catches');
    catches.addEventListener('click', chooseHandler)
    document.getElementById('logout').addEventListener('click', (e) => {
        sessionStorage.clear();
        window.location = './login.html';
    })
    loadData();
});

function chooseHandler(event) {
    if (event.target.textContent == 'Update') {
        updateCatch(event);
    } else if (event.target.textContent == 'Delete') {
        deleteCatch(event);
    }
}

async function updateCatch(event) {
    let data = {
        angler: event.target.parentNode.getElementsByTagName('input')[0].value,
        weight: event.target.parentNode.getElementsByTagName('input')[1].value,
        species: event.target.parentNode.getElementsByTagName('input')[2].value,
        location: event.target.parentNode.getElementsByTagName('input')[3].value,
        bait: event.target.parentNode.getElementsByTagName('input')[4].value,
        captureTime: event.target.parentNode.getElementsByTagName('input')[5].value,
    }
    try {
        if (Object.values(data).some(v => v == '')) {
            throw new Error('All fields are required')
        }
        await fetch(`http://localhost:3030/data/catches/${event.target.getAttribute('data-id')}`, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json', 'X-Authorization': userData.token },
            body: JSON.stringify(data)
        });

        loadData();
    } catch (err) {
        alert(err.message);
    }
}

async function deleteCatch(event) {
    await fetch(`http://localhost:3030/data/catches/${event.target.getAttribute('data-id')}`, {
            method: 'DELETE',
            headers: { 'Content-Type': 'application/json', 'X-Authorization': userData.token },
        });
        event.target.parentNode.parentNode.removeChild(event.target.parentNode);
}

async function loadData() {
    const res = await fetch('http://localhost:3030/data/catches');
    const data = await res.json();

    document.getElementById('catches').replaceChildren(...data.map(createView));
}

async function onCreateSubmit(event) {
    event.preventDefault();
    if (!userData) {
        window.location = './login.html'
        return;
    }
    const formData = new FormData(event.target);

    const data = [...formData.entries()].reduce((a, [k, v]) => Object.assign(a, { [k]: v }), {});
    console.log(data)
    try {
        if (Object.values(data).some(v => v == '')) {
            throw new Error('All fields are required')
        }
        const response = await fetch('http://localhost:3030/data/catches', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json', 'X-Authorization': userData.token },
            body: JSON.stringify(data)
        });
        if (response.ok !== true) {
            const error = await response.json();
            throw new Error(error.message)
        }

        loadData();
        event.target.reset();
    } catch (err) {
        alert(err.message);
    }
}

function createView(item) {
    const isOwner = (userData && item._ownerId == userData.id);
    const element = document.createElement('div');
    element.classList.add('catch');
    element.innerHTML =
        `<label>Angler</label>
    <input type="text" class="angler" value="${item.angler}" ${!isOwner ? 'disabled' : ''}>
    <label>Weight</label>
    <input type="text" class="weight" value="${item.weight}"${!isOwner ? 'disabled' : ''}>
    <label>Species</label>
    <input type="text" class="species" value="${item.species}"${!isOwner ? 'disabled' : ''}>
    <label>Location</label>
    <input type="text" class="location" value="${item.location}"${!isOwner ? 'disabled' : ''}>
    <label>Bait</label>
    <input type="text" class="bait" value="${item.bait}"${!isOwner ? 'disabled' : ''}>
    <label>Capture Time</label>
    <input type="number" class="captureTime" value="${item.captureTime}"${!isOwner ? 'disabled' : ''}>
    <button class="update" data-id="${item._id}" ${!isOwner ? 'disabled' : ''}>Update</button>
    <button class="delete" data-id="${item._id}" ${!isOwner ? 'disabled' : ''}>Delete</button>`

    return element;
}