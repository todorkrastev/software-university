function solve() {
   let creatorInp = document.getElementById('creator');
   let titleInp = document.getElementById('title');
   let categoryInp = document.getElementById('category');
   let contentInpField = document.getElementById('content');
   let createBtn = document.querySelector('form button');
   let articleSection = document.querySelector('.site-content main section');
   let archiveSection = document.querySelector('.archive-section ol');

   createBtn.addEventListener('click', createArticle);

   function createArticle(ev) {
      ev.preventDefault();
      let myArticle = document.createElement('article');

      let myh1 = document.createElement('h1');
      myh1.textContent = `${titleInp.value}`;
      myArticle.appendChild(myh1);

      let myCategoryP = document.createElement('p');
      myCategoryP.innerHTML = `Category: <strong>${categoryInp.value}</strong>`;
      myArticle.appendChild(myCategoryP);

      let myCreatorP = document.createElement('p');
      myCreatorP.innerHTML = `Creator: <strong>${creatorInp.value}</strong>`;
      myArticle.appendChild(myCreatorP);

      let myContentP = document.createElement('p');
      myContentP.textContent = `${contentInpField.value}`;
      myArticle.appendChild(myContentP);

      let myDiv = document.createElement('div');
      myDiv.classList.add('buttons');
      myDiv.innerHTML = `<button class="btn delete">Delete</button><button class="btn archive">Archive</button>`;
      myArticle.appendChild(myDiv);

      articleSection.appendChild(myArticle);
      document.querySelector('form').reset();

      myDiv.querySelectorAll("button")[0].addEventListener('click', () => {
         articleSection.removeChild(myArticle);
      });

      myDiv.querySelectorAll("button")[1].addEventListener('click', () => {
         let newLi = document.createElement('li');
         newLi.textContent = myh1.textContent
         archiveSection.appendChild(newLi);
         let olChildren = Array.from(document.querySelectorAll('.archive-section ol li'));
         let sorted = olChildren.sort((a, b) => a.textContent.localeCompare(b.textContent));
         archiveSection.innerHTML = ``;
         for (let el of sorted) {
            archiveSection.innerHTML += `<li>${el.textContent}</li>`;
         }
         articleSection.removeChild(myArticle);
      });
   }
}