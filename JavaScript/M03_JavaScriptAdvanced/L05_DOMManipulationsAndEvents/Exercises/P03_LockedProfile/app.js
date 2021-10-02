function lockedProfile() {
    let arr = Array
        .from(document.querySelectorAll('.profile button'))
        .forEach(b => b.addEventListener('click', onToggle));

    function onToggle(e) {
        const profile = e.target.parentElement;
        const isActive = profile.querySelector('input[type="radio"][value="unlock"]').checked;

        if (isActive) {
            const infoDif = profile.querySelector('div');

            if (e.target.textContent == 'Show more') {
                infoDif.style.display = 'block';
                e.target.textContent = 'Hide it';
            } else {
                infoDif.style.display = '';
                e.target.textContent = 'Show more';
            }
        }
    }



    // second option


    // document.getElementById('main').addEventListener('click', onToggle);

    // function onToggle(e) {
    //     if (e.target.tagName == 'BUTTON') {
    //         const profile = e.target.parentElement;
    //         const isActive = profile.querySelector('input[type="radio"][value="unlock"]').checked;

    //         if (isActive) {
    //             const infoDif = profile.querySelector('div');

    //             if (e.target.textContent == 'Show more') {
    //                 infoDif.style.display = 'block';
    //                 e.target.textContent = 'Hide it';
    //             } else {
    //                 infoDif.style.display = '';
    //                 e.target.textContent = 'Show more';
    //             }
    //         }
    //     }
    // }



    // third option


    // const toggle = (btn, content) => {
    //     if (btn.innerHTML === "Show more") {
    //         btn.innerHTML = "Hide it"
    //         content.style.display = "block"
    //     } else {
    //         btn.innerHTML = "Show more"
    //         content.style.display = "none"
    //     }
    // }

    // document.getElementById("main").addEventListener("click", e => {
    //     if (e.target.tagName === "BUTTON") {
    //         const parent = e.target.parentNode
    //         const isUnlocked =
    //             parent.querySelector("input[type=radio]:checked").value ===
    //             "unlock"

    //         if (isUnlocked) {
    //             const infoDiv = parent.querySelector("div")
    //             toggle(e.target, infoDiv)
    //         }
    //     }
    // })
}
