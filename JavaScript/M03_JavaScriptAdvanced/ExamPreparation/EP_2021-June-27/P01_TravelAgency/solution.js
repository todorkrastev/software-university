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
