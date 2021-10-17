function solve() {
   let createButton = document.querySelector('.site-content aside button.btn.create');
   createButton.addEventListener('click', createArticleHandler);

   function createArticleHandler(e) {
      e.preventDefault();

      let authorInput = document.querySelector('#creator');
      let titleInput = document.querySelector('#title');
      let categoryInput = document.querySelector('#category');
      let contentTextArea = document.querySelector('#content');

      let articleElement = document.createElement('article');

      let titleHeading = document.createElement('h1');
      titleHeading.textContent = titleInput.value;

      let categoryParagraph = document.createElement('p');
      categoryParagraph.textContent = 'Category:';
      let categoryStrong = document.createElement('strong');
      categoryStrong.textContent = categoryInput.value;
      categoryParagraph.appendChild(categoryStrong);

      let creatorParagraph = document.createElement('p');
      creatorParagraph.textContent = 'Creator:';
      let creatorStrong = document.createElement('strong');
      creatorStrong.textContent = authorInput.value;
      creatorParagraph.appendChild(creatorStrong);

      let contentParagraph = document.createElement('p');
      contentParagraph.textContent = contentTextArea.value;

      let buttonsDiv = document.createElement('div');
      buttonsDiv.classList.add('buttons');

      let deleteButton = document.createElement('button');
      deleteButton.textContent = 'Delete';
      deleteButton.classList.add('btn', 'delete');
      deleteButton.addEventListener('click', deleteArticleHandler);

      let archiveButton = document.createElement('button');
      archiveButton.textContent = 'Archive';
      archiveButton.classList.add('btn', 'archive');
      archiveButton.addEventListener('click', archiveArticleHandler);

      buttonsDiv.appendChild(deleteButton);
      buttonsDiv.appendChild(archiveButton);

      articleElement.appendChild(titleHeading);
      articleElement.appendChild(categoryParagraph);
      articleElement.appendChild(creatorParagraph);
      articleElement.appendChild(contentParagraph);
      articleElement.appendChild(buttonsDiv);

      let postsSection = document.querySelector('.site-content main section');
      postsSection.appendChild(articleElement);

   }

   function deleteArticleHandler(e) {
      let deleteButton = e.target;
      let articleToDelete = deleteButton.parentElement.parentElement;
      articleToDelete.remove();
   }

   function archiveArticleHandler(e) {
      let articleToArchive = e.target.parentElement.parentElement;
      let archiveOl = document.querySelector('.archive-section ol');

      let archiveLis = Array.from(archiveOl.querySelectorAll('li'));
      let articleTitleHeading = articleToArchive.querySelector('h1');
      let articleTitle = articleTitleHeading.textContent;

      let newTitleLi = document.createElement('li');
      newTitleLi.textContent = articleTitle;

      articleToArchive.remove();

      archiveLis.push(newTitleLi);
      archiveLis
         .sort((a, b) => a.textContent.localeCompare(b.textContent))
         .forEach(li => archiveOl.appendChild(li));
   }
}



// second option


// function solve() {
//    let creatorInp = document.getElementById('creator');
//    let titleInp = document.getElementById('title');
//    let categoryInp = document.getElementById('category');
//    let contentInpField = document.getElementById('content');
//    let createBtn = document.querySelector('form button');
//    let articleSection = document.querySelector('.site-content main section');
//    let archiveSection = document.querySelector('.archive-section ol');

//    createBtn.addEventListener('click', createArticle);

//    function createArticle(ev) {
//       ev.preventDefault();
//       let article = document.createElement('article');

//       let h1 = document.createElement('h1');
//       h1.textContent = `${titleInp.value}`;
//       article.appendChild(h1);
//       let categoryP = document.createElement('p');

//       categoryP.innerHTML = `Category: <strong>${categoryInp.value}</strong>`;
//       article.appendChild(categoryP);

//       let authorP = document.createElement('p');
//       authorP.innerHTML = `Creator: <strong>${creatorInp.value}</strong>`;
//       article.appendChild(authorP);

//       let contentP = document.createElement('p');
//       contentP.textContent = `${contentInpField.value}`;
//       article.appendChild(contentP);

//       let div = document.createElement('div');
//       div.classList.add('buttons');
//       div.innerHTML = `<button class="btn delete">Delete</button><button class="btn archive">Archive</button>`;
//       article.appendChild(div);

//       articleSection.appendChild(article);
//       document.querySelector('form').reset();

//       div.querySelectorAll("button")[0].addEventListener('click', () => {
//          articleSection.removeChild(article);
//       });

//       div.querySelectorAll("button")[1].addEventListener('click', () => {
//          let newLi = document.createElement('li');
//          newLi.textContent = h1.textContent
//          archiveSection.appendChild(newLi);
//          let olChildren = Array.from(document.querySelectorAll('.archive-section ol li'));
//          let sorted = olChildren.sort((a, b) => a.textContent.localeCompare(b.textContent));
//          archiveSection.innerHTML = ``;
//          for (let el of sorted) {
//             archiveSection.innerHTML += `<li>${el.textContent}</li>`;
//          }
//          articleSection.removeChild(article);
//       });
//    }
// }
