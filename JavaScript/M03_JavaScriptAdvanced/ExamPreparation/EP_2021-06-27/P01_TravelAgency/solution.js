window.addEventListener('load', solution);

function solution() {
  let fullName = document.querySelector('#fname');
  let email = document.querySelector('#email');
  let phone = document.querySelector('#phone');
  let address = document.querySelector('#address');
  let postalCode = document.querySelector('#code');

  let submitButton = document.querySelector('#submitBTN');
  submitButton.addEventListener('click', addData);

  function addData() {
    let fullNameValue = fullName.value;
    let emailValue = email.value;
    let phoneValue = phone.value;
    let addressValue = address.value;
    let postalCodeValue = postalCode.value;

    if (fullNameValue !== '' && emailValue !== '') {
      fullName.value = '';
      email.value = '';
      phone.value = '';
      address.value = '';
      postalCode.value = '';

      const data = `<li>Full Name: ${fullNameValue}</li>
      <li>Email: ${emailValue}</li>
      <li>Phone Number: ${phoneValue}</li>
      <li>Address: ${addressValue}</li>
      <li>Postal Code: ${postalCodeValue}</li>`;

      let infoPreview = document.querySelector('#infoPreview');
      infoPreview.innerHTML = data;

      let editButton = document.querySelector('#editBTN');
      let continueButton = document.querySelector('#continueBTN');

      submitButton.disabled = true;
      editButton.disabled = false;
      continueButton.disabled = false;

      editButton.addEventListener('click', editData);
      continueButton.addEventListener('click', setReservation);
    }
  }

  function editData() {
    let info = this.parentElement.parentElement.firstElementChild.children;

    fullName.value = info[0].textContent.replace('Full Name: ', '');
    email.value = info[1].textContent.replace('Email: ', '');
    phone.value = info[2].textContent.replace('Phone Number: ', '');
    address.value = info[3].textContent.replace('Address: ', '');
    postalCode.value = info[4].textContent.replace('Postal Code: ', '');

    this.parentElement.parentElement.firstElementChild.innerHTML = '';

    this.disabled = true;
    this.nextElementSibling.disabled = true;
    this.parentElement.parentElement.parentElement.parentElement.querySelector('#submitBTN').disabled = false;

    console.log(this);
  }

  function setReservation() {
    document.querySelector('#block').innerHTML = `<h3>Thank you for your reservation!</h3>`;
  }
}



// refactoring

/*
function solution() {
  let fullNameField = document.getElementById('fname');
  let emailField = document.getElementById('email');
  let phoneNumberField = document.getElementById('phone');
  let addressField = document.getElementById('address');
  let postalCodeField = document.getElementById('code');
  const submitBtn = document.getElementById('submitBTN');
  const editBtn = document.getElementById('editBTN');
  const continueBtn = document.getElementById('continueBTN');

  submitBtn.addEventListener('click', submitHandler);

  function submitHandler(event) {
    event.preventDefault();
    const fullName = fullNameField.value;
    const email = emailField.value;
    const phone = phoneNumberField.value;
    const address = addressField.value;
    const postalCode = postalCodeField.value;

    if (fullName == '' && email == '') {
      return;
    }

    const ul = document.querySelector('#infoPreview');

    ul.appendChild(e('li', {}, `Full Name: ${fullName}`));
    ul.appendChild(e('li', {}, `Email: ${email}`));
    ul.appendChild(e('li', {}, `Phone Number: ${phone}`));
    ul.appendChild(e('li', {}, `Address: ${address}`));
    ul.appendChild(e('li', {}, `Postal Code: ${postalCode}`));


    fullNameField.value = '';
    emailField.value = '';
    phoneNumberField.value = '';
    addressField.value = '';
    postalCodeField.value = '';

    submitBtn.disabled = true;
    editBtn.disabled = false;
    continueBtn.disabled = false;

    editBtn.addEventListener('click', () => {
      fullNameField.value = fullName;
      emailField.value = email;
      phoneNumberField.value = phone;
      addressField.value = address;
      postalCodeField.value = postalCode;

      submitBtn.disabled = false;
      editBtn.disabled = true;
      continueBtn.disabled = true;

      // ul.remove();
      // document.querySelector('.preview').appendChild(e('ul', { id: 'infoPreview' }));
      let inputs = Array.from(event.target.parentElement.parentElement.querySelectorAll('li'));
      inputs.forEach(el => el.remove());

    });
    continueBtn.addEventListener('click', () => {
      const parent = document.getElementById("block");
      while (parent.firstChild) {
        parent.firstChild.remove();
      }
      parent.appendChild(e('h3', {}, 'Thank you for your reservation!'));
    });
  }



  function e(type, attributes, ...content) {
    const result = document.createElement(type);

    for (let [attr, value] of Object.entries(attributes || {})) {
      if (attr.substring(0, 2) == 'on') {
        result.addEventListener(attr.substring(2).toLocaleLowerCase(), value);
      } else {
        result[attr] = value;
      }
    }

    content = content.reduce((a, c) => a.concat(Array.isArray(c) ? c : [c]), []);

    content.forEach(e => {
      if (typeof e == 'string' || typeof e == 'number') {
        const node = document.createTextNode(e);
        result.appendChild(node);
      } else {
        result.appendChild(e);
      }
    });

    return result;
  }
}
 */
