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


// refactoring


/*
function solve() {
   let createBtn = document.querySelector('.btn');
   createBtn.addEventListener('click', onClick);
   let posts = document.querySelector('.site-content main section');

   function onClick(event) {
      event.preventDefault();

      let inputs = {
         author: document.querySelector('#creator'),
         title: document.querySelector('#title'),
         category: document.querySelector('#category'),
         content: document.querySelector('#content'),
      };

      let deleteBtn = e('button', { className: 'btn delete' }, 'Delete');
      let archiveBtn = e('button', { className: 'btn archive' }, 'Archive');

      posts.appendChild(e('article', {},
         e('h1', {}, `${inputs.title.value}`),
         e('p', {}, 'Category:',
            e('strong', {}, `${inputs.category.value}`)),
         e('p', {}, 'Creator:',
            e('strong', {}, `${inputs.author.value}`)),
         e('p', {}, `${inputs.content.value}`),
         e('div', { className: 'buttons' },
            deleteBtn,
            archiveBtn
         )
      ));

      deleteBtn.addEventListener('click', deleteHandler);
      archiveBtn.addEventListener('click', archiveHandler);


      document.querySelector('#creator').value = '';
      document.querySelector('#title').value = '';
      document.querySelector('#category').value = '';
      document.querySelector('#content').value = '';
   }

   function archiveHandler() {
      let article = this.parentElement.parentElement;
      let title = article.querySelector('h1').textContent;
      let ol = document.querySelector('.archive-section ol');
      ol.appendChild(e('li', {}, `${title}`));
      article.remove();

      Array.from(ol.children)
         .sort((a, b) => a.textContent.localeCompare(b.textContent))
         .forEach(e => ol.appendChild(e));
   }

   function deleteHandler() {
      let article = this.parentElement.parentElement;
      article.remove();
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
