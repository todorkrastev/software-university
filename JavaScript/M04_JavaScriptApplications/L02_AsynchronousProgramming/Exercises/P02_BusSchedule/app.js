function solve() {
    const html = {
        info: document.querySelector('#info'),
        departButton: document.querySelector('#depart'),
        arriveButton: document.querySelector('#arrive')
    };

    const getStop = async (name) => {
        try {
            const stop = await fetch(`http://localhost:3030/jsonstore/bus/schedule/${name}`);

            return await stop.json();
        } catch (e) {
            html.info.innerHTML = 'Error';
            html.arriveButton.disabled = true;
            html.departButton.disabled = true;
        }
    }

    let nextStop;
    let nextStopName = 'depot';

    async function depart() {
        html.info.textContent = 'Loading...';
        html.departButton.disabled = true;
        html.arriveButton.disabled = false;
        nextStop = await getStop(nextStopName);
        html.info.textContent = `Next stop ${nextStop.name}`;
    }

    function arrive() {
        html.info.textContent = 'Loading...';
        html.departButton.disabled = false;
        html.arriveButton.disabled = true;

        html.info.textContent = `Arriving at ${nextStop.name}`;
        nextStopName = nextStop.next;
    }

    return {
        depart,
        arrive
    };
}

let result = solve();



// second option


// function solve() {
//     const label = document.querySelector('#info span');
//     const departBtn = document.getElementById('depart');
//     const arriveBtn = document.getElementById('arrive');

//     let stop = {
//         next: 'depot'
//     };

//     async function depart() {
//         departBtn.disabled = true;

//         const url = `http://localhost:3030/jsonstore/bus/schedule/${stop.next}`;

//         const res = await fetch(url);
//         stop = await res.json();

//         label.textContent = `Next stop ${stop.name}`;

//         arriveBtn.disabled = false;
//     }

//     function arrive() {
//         label.textContent = `Arriving at ${stop.name}`;

//         departBtn.disabled = false;
//         arriveBtn.disabled = true;
//     }

//     return {
//         depart,
//         arrive
//     };
// }

// let result = solve();
