function solve() {
    let siteContent = document.querySelector('.site-content section');
    let createBtn = document.querySelector('.btn.create');
    createBtn.addEventListener('click', onClick);

    function onClick(event) {
        event.preventDefault();

        let inputs = {
            author: document.querySelector('#creator'),
            title: document.querySelector('#title'),
            category: document.querySelector('#category'),
            content: document.querySelector('#content'),
        }


        let deleteBtn = e('button', { className: 'btn delete' }, 'Delete');
        let archiveBtn = e('button', { className: 'btn archive' }, 'Archive');
        let article = e('article', {},
            e('h1', {}, `${inputs.title.value.trim()}`),
            e('p', {}, 'Category:',
                e('strong', {}, `${inputs.category.value.trim()}`)),
            e('p', {}, 'Creator:',
                e('strong', {}, `${inputs.author.value.trim()}`)),
            e('p', {}, `${inputs.content.value.trim()}`),
            e('div', { className: 'buttons' },
                deleteBtn,
                archiveBtn));
        siteContent.appendChild(article);

        archiveBtn.addEventListener('click', onArchive);
        deleteBtn.addEventListener('click', onDelete);

        inputs.author.value = '';
        inputs.title.value = '';
        inputs.category.value = '';
        inputs.content.value = '';

    }

    function onDelete() {
        this.parentElement.parentElement.remove();
    }

    function onArchive() {
        let author = this.parentElement.parentElement.querySelector('h1').textContent;
        let archiveSection = document.querySelector('.archive-section ol');
        archiveSection.appendChild(e('li', {}, `${author}`));
        let list = Array.from(archiveSection.querySelectorAll('li'));
        list
            .sort((a, b) => a.textContent.localeCompare(b.textContent))
            .forEach(li => archiveSection.appendChild(li));

        this.parentElement.parentElement.remove();
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



// Second option

/*
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
*/
