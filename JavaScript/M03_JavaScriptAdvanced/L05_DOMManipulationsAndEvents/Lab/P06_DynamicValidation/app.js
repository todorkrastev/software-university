function validate() {
    let input = document.getElementById('email');
    input.addEventListener('change', onValidation);

    function onValidation({ target }) {
        const pattern =
            /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

        pattern.test(target.value) ?
            target.classList.remove('error') :
            target.classList.add('error');

        // using className instead of classList   

        // pattern.test(target.value) ?
        //     target.className = '' :
        //     target.className = 'error';
    }
}
