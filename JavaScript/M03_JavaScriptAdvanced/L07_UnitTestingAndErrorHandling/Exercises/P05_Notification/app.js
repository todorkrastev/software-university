function notify(message) {
  const notification = document.querySelector('#notification');
  notification.textContent = message;
  notification.style.display = 'block';

  notification.addEventListener('click', reveal);

  function reveal() {
    this.style.display = 'none';
  }



  // modification


  // const notification = document.getElementById('notification');
  // notification.textContent = message;
  // notification.style.display = 'block';
  // notification.addEventListener('click', () => notification.style.display = 'none');
}
