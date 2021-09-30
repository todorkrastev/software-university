function focused() {
    const fields = Array.from(document.getElementsByTagName('input'));

    for (const field of fields) {
        field.addEventListener('focus', onFocus);
        field.addEventListener('blur', onBlur);
    }

    function onFocus(ev) {
        ev.target.parentNode.className = 'focused';
    }

    function onBlur(ev) {
        ev.target.parentNode.className = '';
    }

    // second option

    // Array
    //     .from(document.getElementsByTagName('input'))
    //     .forEach(field => {
    //         field.addEventListener('focus', onFocus);
    //         field.addEventListener('blur', onBlur);

    //     });

    // function onFocus(ev) {
    //     ev.target.parentNode.classList.add('focused');
    // }

    // function onBlur(ev) {
    //     ev.target.parentNode.classList.remove('focused');
    // }

    // third option

    // Array
    //     .from(document.getElementsByTagName('input'))
    //     .forEach(field => {
    //         field.addEventListener('focus', ({ target: { parentNode } }) => parentNode.classList.add('focused'));
    //         field.addEventListener('blur', ({ target: { parentNode } }) => parentNode.classList.remove('focused'));
    //     });

    // fourth option

    // const inputs = document.getElementsByTagName("input")

    // const addFocus = e => (e.parentNode.className = "focused")
    // const removeFocus = e => (e.parentNode.className = "")

    // Array.from(inputs).forEach(x => {
    //     x.addEventListener("focus", e => addFocus(e.target))
    //     x.addEventListener("blur", e => removeFocus(e.target))
    // })
}
