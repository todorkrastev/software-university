function toggle() {
    let button = document.getElementsByClassName('button')[0];
    let info = document.getElementById('extra');

    if (button.textContent == 'More') {
        info.style.display = 'block';
        button.textContent = 'Less';
    } else {
        info.style.display = 'none';
        button.textContent = 'More';
    }

    // second option

    // const html = {
    //     button: document.getElementsByClassName("button")[0],
    //     content: document.getElementById("extra"),
    // }

    // if (html.button.innerHTML === "More") {
    //     html.button.innerHTML = "Less"
    //     html.content.style.display = "block"
    // } else {
    //     html.button.innerHTML = "More"
    //     html.content.style.display = "none"
    // }
}
