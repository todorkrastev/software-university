async function getInfo() {
    const html = {
        stopName: document.querySelector('#stopName'),
        buses: document.querySelector('#buses'),
        stopId: document.querySelector('#stopId'),
        submitButton: document.querySelector('#submit')
    };

    html.submitButton.disabled = true;

    const url = `http://localhost:3030/jsonstore/bus/businfo/${html.stopId.value} `;

    try {
        html.stopName.textContent = 'Loading...';
        html.buses.replaceChildren();

        const response = await fetch(url);
        if (response.status !== 200) {
            throw new Error('Stop ID not found');
        }

        const data = await response.json();

        html.stopName.textContent = data.name;

        Object.entries(data.buses).forEach(([bus, time]) => {
            const liElement = document.createElement('li');
            liElement.textContent = `Bus ${bus} arrives in ${time} minutes`;

            html.buses.appendChild(liElement);
        });


    } catch (error) {
        html.stopName.textContent = 'Error';
    }

    html.submitButton.disabled = false;
}
