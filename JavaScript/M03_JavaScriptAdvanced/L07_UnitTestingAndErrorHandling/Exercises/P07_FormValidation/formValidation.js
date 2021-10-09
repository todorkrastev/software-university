function validate() {
    let submitButton = document.getElementById('submit');
    submitButton.addEventListener('click', validateFormHandler);
    let isCompanyCheckbox = document.getElementById('company');
    isCompanyCheckbox.addEventListener('change', onIsCompanyHandler);

    function validateFormHandler(e) {
        e.preventDefault();
        let usernameInput = document.getElementById('username');
        let usernameRegex = /^[a-zA-Z0-9]{3,20}$/;
        let usernameIsValid = usernameRegex.test(usernameInput.value);
        setBorder(usernameInput, usernameIsValid);

        let emailInput = document.getElementById('email');
        let emailRegex = /^.*@.*\..*$/
        let emailIsValid = emailRegex.test(emailInput.value);
        setBorder(emailInput, emailIsValid);

        let passwordRegex = /^\w{5,15}$/;
        let passwordInput = document.getElementById('password');
        let confirmPasswordInput = document.getElementById('confirm-password');
        let passwordIsValid = passwordRegex.test(passwordInput.value);
        let passwordsAreOk = passwordIsValid &&
            passwordInput.value === confirmPasswordInput.value;
        setBorder(passwordInput, passwordsAreOk);
        setBorder(confirmPasswordInput, passwordsAreOk);

        let companyNumberIsValid = false;
        let isCompanyCheckbox = document.getElementById('company');
        if (isCompanyCheckbox.checked) {
            let companyNumberInput = document.getElementById('companyNumber');
            if (companyNumberInput.value.trim() !== '' && !isNaN(Number(companyNumberInput.value))) {
                let companyNumber = Number(companyNumberInput.value);
                if (companyNumber >= 1000 && companyNumber <= 9999) {
                    companyNumberIsValid = true;
                }
            }

            setBorder(companyNumberInput, companyNumberIsValid);
        }

        let validDiv = document.getElementById('valid');
        let mainInputsAreValid = usernameIsValid && emailIsValid && passwordsAreOk
        let companyInfoIsValid = !isCompanyCheckbox.checked || (isCompanyCheckbox.checked && companyNumberIsValid);
        let shouldShowValidDiv = mainInputsAreValid && companyInfoIsValid;
        validDiv.style.display = shouldShowValidDiv ? 'block' : 'none';
    }

    function onIsCompanyHandler(e) {
        let companyInfoFieldset = document.getElementById('companyInfo');
        companyInfoFieldset.style.display = e.target.checked ? 'block' : 'none';
    }

    function setBorder(element, isValid) {
        if (isValid) {
            element.style.setProperty('border', 'none');
        } else {
            element.style.setProperty('border', '2px solid red');
        }
    }



    // second option

    
    // const html = {
    //     companyCheck: document.getElementById(`company`),
    //     submit: document.getElementById(`submit`),
    //     validDiv: document.getElementById(`valid`),
    //     companyInfo: document.getElementById(`companyInfo`)
    // };

    // const inputFields = {
    //     username: document.getElementById(`username`),
    //     email: document.getElementById(`email`),
    //     password: document.getElementById(`password`),
    //     'confirm-password': document.getElementById(`confirm-password`),
    //     companyNumber: document.getElementById(`companyNumber`),
    // };

    // const checkLength = (v, s, e) => v.length >= s && v.length <= e;
    // const checkPassword = (v, s, e, f) =>
    //     checkLength(v, s, e) && /^\w+$/g.test(v) && v === inputFields[f].value;

    // const validate = {
    //     username: (v) => checkLength(v, 3, 20) && /^[a-zA-Z0-9]*$/g.test(v),
    //     password: (v) => checkPassword(v, 5, 15, 'confirm-password'),
    //     'confirm-password': (v) => checkPassword(v, 5, 15, 'password'),
    //     email: (v) => /^.*@.*\..*$/g.test(v),
    //     companyNumber: (v, c) => c ? v >= 1000 && v <= 9999 : true
    // };

    // const changeBorder = (c, e) => {
    //     const style = c ? 'border: none' : 'border-color: red';

    //     e.style = style;
    // };

    // html.companyCheck.addEventListener('change', (e) => {
    //     if (e.target.checked === true) {
    //         html.companyInfo.style.display = 'block';
    //     } else {
    //         html.companyInfo.style.display = 'none';
    //     }
    // });

    // html.submit.addEventListener('click', (e) => {
    //     e.preventDefault();
    //     const checked = html.companyCheck.checked;
    //     let oneInvalid = false;

    //     Object.entries(inputFields).forEach(([name, valueField]) => {
    //         const valid = validate[name](valueField.value, checked);

    //         changeBorder(valid, inputFields[name]);

    //         if (!valid) oneInvalid = true;
    //     })

    //     if (oneInvalid) {
    //         html.validDiv.style.display = 'none';
    //     } else {
    //         html.validDiv.style.display = 'block';
    //     }
    // });
}
