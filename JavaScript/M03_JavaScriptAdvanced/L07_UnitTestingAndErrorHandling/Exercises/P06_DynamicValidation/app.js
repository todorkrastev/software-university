function validate() {
    const input = document.querySelector('#email');

    input.addEventListener('change', change);

    function change() {
        let email = this.value;
        /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(email) ?
            this.className = '' :
            this.className = 'error';
    }



    // second option


    // const input = document.getElementById("email");

    // function isValidEmail(str) {
    //     if (/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(str)) return true;

    //     return false;
    // }

    // function applyStyle(e, email) {
    //     e.className = isValidEmail(email) ? "" : "error";
    // }
    // input.addEventListener("change", e => applyStyle(e.target, e.target.value));
}
