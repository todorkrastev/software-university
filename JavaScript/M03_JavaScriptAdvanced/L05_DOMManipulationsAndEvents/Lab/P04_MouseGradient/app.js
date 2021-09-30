function attachGradientEvents() {
    const gradient = document.getElementById('gradient');
    gradient.addEventListener('mousemove', onMove);
    const output = document.getElementById('result');

    function onMove(ev) {
        const box = ev.target;
        const offset = Math.floor(ev.offsetX / box.clientWidth * 100); // or box.offsetWidth

        output.textContent = `${offset}%`;
    }

    // second option

    // const html = {
    //     hoverDiv: document.getElementById("gradient"),
    //     output: document.getElementById("result"),
    // }

    // function displayPercent(event, element) {
    //     html.output.textContent = `${Math.floor(
    //         (event.offsetX / event.target.clientWidth) * 100
    //     )}%`
    // }

    // html.hoverDiv.addEventListener("mousemove", e =>
    //     displayPercent(e, html.hoverDiv)
    // )
}
