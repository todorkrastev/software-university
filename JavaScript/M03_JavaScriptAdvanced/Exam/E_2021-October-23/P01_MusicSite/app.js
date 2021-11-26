window.addEventListener('load', solve);

function solve() {
    let addButton = document.querySelector('#add-btn');
    addButton.addEventListener('click', AddSong);
    let collectionOfSongs = document.querySelector('.all-hits-container');

    function AddSong(event) {
        event.preventDefault();

        let genre = document.querySelector('#genre');
        let name = document.querySelector('#name');
        let author = document.querySelector('#author');
        let date = document.querySelector('#date');

        if (genre.value !== '' && name.value !== '' && author !== '' && date !== '') {
            let hitsInfoDiv = document.createElement('div');
            hitsInfoDiv.classList.add("hits-info");

            let srcImg = document.createElement('img');
            srcImg.src = "./static/img/img.png";
            hitsInfoDiv.appendChild(srcImg);

            let genreH2 = document.createElement('h2');
            genreH2.textContent = `Genre: ${genre.value}`;
            hitsInfoDiv.appendChild(genreH2);

            let nameH2 = document.createElement('h2');
            nameH2.textContent = `Name: ${name.value}`;
            hitsInfoDiv.appendChild(nameH2);

            let authorH2 = document.createElement('h2');
            authorH2.textContent = `Author: ${author.value}`;
            hitsInfoDiv.appendChild(authorH2);

            let dateH3 = document.createElement('h3');
            dateH3.textContent = `Date: ${date.value}`;
            hitsInfoDiv.appendChild(dateH3);

            let saveButton = document.createElement('button');
            saveButton.classList.add("save-btn");
            saveButton.textContent = 'Save song';
            hitsInfoDiv.appendChild(saveButton);

            let likeButton = document.createElement('button');
            likeButton.classList.add("like-btn");
            likeButton.textContent = 'Like song';
            hitsInfoDiv.appendChild(likeButton);

            let deleteButton = document.createElement('button');
            deleteButton.classList.add("delete-btn");
            deleteButton.textContent = 'Delete';
            hitsInfoDiv.appendChild(deleteButton);

            collectionOfSongs.appendChild(hitsInfoDiv);

            likeButton.addEventListener('click', addLike);
            saveButton.addEventListener('click', saveSong);
            deleteButton.addEventListener('click', deleteSong);

            genre.value = '';
            name.value = '';
            author.value = '';
            date.value = '';
        }
    }

    function addLike() {
        let totalLikes = document.querySelector('#total-likes p');
        let counter = totalLikes.textContent.replace('Total Likes: ', '');
        counter = Number(counter);
        counter++;
        totalLikes.textContent = `Total Likes: ${counter}`;
        this.disabled = true;
    }

    function saveSong() {
        let savedSongs = document.querySelector('.saved-container');
        let info = this.parentElement;
        info.removeChild(info.querySelector('button[class="save-btn"]'));
        info.removeChild(info.querySelector('button[class="like-btn"]'));
        savedSongs.appendChild(info);

        let deleteBtn = info.querySelector('button[class="delete-btn"]');
        deleteBtn.addEventListener('click', deleteSong);
    }

    function deleteSong() {
        this.parentElement.remove();
    }
}


// refactoring


// function solve() {
//     const container = document.querySelectorAll('.container-text input');
//     const addBtn = document.querySelector('#add-btn');
//     const songsCollection = document.querySelector('.all-hits-container');
//     const totalLikes = document.querySelector('.likes p');
//     const savedSongs = document.querySelector('.saved-container');

//     addBtn.addEventListener('click', onClick);

//     const input = {
//         genre: container[0],
//         name: container[1],
//         author: container[2],
//         date: container[3]
//     }

//     function onClick(event) {
//         event.preventDefault();

//         const genre = input.genre.value.trim();
//         const name = input.name.value.trim();
//         const author = input.author.value.trim();
//         const date = input.date.value.trim();

//         if (genre != '' && name != '' && author != '' && date != '') {
//             const saveBtn = e('button', {className: 'save-btn'}, 'Save song');
//             const likeBtn = e('button', {className: 'like-btn'}, 'Like song');
//             const deleteBtn = e('button', {className: 'delete-btn'}, 'Delete');

//             const div = e('div', {className: 'hits-info'},
//                 e('img', {src: './static/img/img.png'}),
//                 e('h2', {}, `Genre: ${genre}`),
//                 e('h2', {}, `Name: ${name}`),
//                 e('h2', {}, `Author: ${author}`),
//                 e('h3', {}, `Date: ${date}`),
//                 saveBtn,
//                 likeBtn,
//                 deleteBtn
//             );

//             songsCollection.appendChild(div);

//             likeBtn.addEventListener('click', () => {
//                 let [text, number] = totalLikes.textContent.split(': ');
//                 number = Number(number);
//                 number += 1;
//                 totalLikes.textContent = `Total Likes: ${number}`;
//                 likeBtn.disabled = true;
//             });

//             saveBtn.addEventListener('click', () => {
//                 savedSongs.appendChild(div);
//                 saveBtn.remove();
//                 likeBtn.remove();
//             })

//             deleteBtn.addEventListener('click', () => {
//                 div.remove();
//             })
//         }
//         input.genre.value = ''
//         input.name.value = '';
//         input.author.value = '';
//         input.date.value = '';
//     }

//     function e(type, attributes, ...content) {
//         const result = document.createElement(type);

//         for (let [attr, value] of Object.entries(attributes || {})) {
//             if (attr.substring(0, 2) == 'on') {
//                 result.addEventListener(attr.substring(2).toLocaleLowerCase(), value);
//             } else {
//                 result[attr] = value;
//             }
//         }

//         content = content.reduce((a, c) => a.concat(Array.isArray(c) ? c : [c]), []);

//         content.forEach(e => {
//             if (typeof e == 'string' || typeof e == 'number') {
//                 const node = document.createTextNode(e);
//                 result.appendChild(node);
//             } else {
//                 result.appendChild(e);
//             }
//         });

//         return result;
//     }
// }


// second option


// function solve() {
//     let genreField = document.getElementById('genre');
//     let nameField = document.getElementById('name');
//     let autorField = document.getElementById('author');
//     let dateField = document.getElementById('date');
//     let buttonField = document.getElementById("add-btn");
//     buttonField.addEventListener('click', isValid);
//     let collection = document.querySelector('.all-hits-container');
//     let saved = document.querySelector('.saved-container');

//     function deleteSong(e) {
//         let song = e.target.parentElement;
//         song.remove();
//     }

//     function moveToSave(e) {
//         let divToMove = e.target.parentElement;
//         let saveButton = e.target;
//         let likeButton = e.target.nextElementSibling;
//         saveButton.remove();
//         likeButton.remove();
//         saved.appendChild(divToMove);
//     }

//     function gainLikes(e) {
//         let likesField = document.querySelector('.likes p');
//         let likes = likesField.textContent;
//         let [label, num] = likes.split(': ');
//         num = Number(num);
//         num++;
//         let result = `${label}: ${num}`;
//         likesField.textContent = result;
//         console.log(e.target);
//         e.target.setAttribute("disabled", 'true');
//     }

//     function getInfo(genre, name, autor, date) {
//         let divEl = createEl('div', ['class', 'hits-info'], '');
//         let imgEl = createEl('img', '', '');
//         imgEl.setAttribute('src', "./static/img/img.png");
//         let genreEl = createEl('h2', '', `Genre: ${genre}`);
//         let nameEl = createEl('h2', '', `Name: ${name}`);
//         let autorEl = createEl('h2', '', `Author: ${autor}`);
//         let dateEl = createEl('h3', '', `Date: ${date}`);
//         let buttonSave = createEl('button', ['class', 'save-btn'], 'Save song');
//         buttonSave.addEventListener('click', moveToSave);
//         let buttonLike = createEl('button', ['class', 'like-btn'], 'Like song');
//         buttonLike.addEventListener('click', gainLikes);
//         let buttonDelete = createEl('button', ['class', 'delete-btn'], 'Delete');
//         buttonDelete.addEventListener('click', deleteSong);
//         divEl.appendChild(imgEl);
//         divEl.appendChild(genreEl);
//         divEl.appendChild(nameEl);
//         divEl.appendChild(autorEl);
//         divEl.appendChild(dateEl);
//         divEl.appendChild(buttonSave);
//         divEl.appendChild(buttonLike);
//         divEl.appendChild(buttonDelete);

//         collection.appendChild(divEl);
//         console.log(this);
//     }


//     function isValid(e) {
//         e.preventDefault();
//         let patern = /^(0[1-9]|[12][0-9]|3[01]).(0[1-9]|1[0-2]).\d{4}$/;
//         let result = true;
//         if (genreField.value.trim() === '' || nameField.value.trim() === '' || autorField.value.trim() === '') {
//             result = false;
//         }
//         let testDate = dateField.value.match(patern)
//         console.log(testDate);
//         if (result === true && testDate !== null) {
//             getInfo(genreField.value.trim(), nameField.value.trim(), autorField.value.trim(), testDate[0]);
//         }
//         genreField.value = "";
//         nameField.value = "";
//         autorField.value = "";
//         dateField.value = "";

//     }

//     function createEl(type, atrr, content) {
//         let result = document.createElement(type);
//         if (atrr !== "") {
//             for (let i = 0; i < atrr.length; i += 2) {
//                 result.setAttribute(atrr[i], atrr[i + 1]);
//             }
//         }
//         if (content !== '') {
//             result.textContent = content;
//         }
//         return result;
//     }
// }


// third option


// function solve() {
//     const genreField = document.getElementById('genre');
//     const songField = document.getElementById('name');
//     const authorField = document.getElementById('author');
//     const dateField = document.getElementById('date');
//     const addBtn = document.getElementById('add-btn');
//     let totalLikes = 0;

//     addBtn.addEventListener('click', addHandler);

//     function addHandler(event) {
//         event.preventDefault();
//         const genre = genreField.value;
//         const song = songField.value;
//         const author = authorField.value;
//         const date = dateField.value;

//         if (genre === '' || song === '' || author === '' || date === '') {
//             return;
//         }

//         genreField.value = '';
//         songField.value = '';
//         authorField.value = '';
//         dateField.value = '';

//         const divAllHits = document.querySelector('.all-hits-container');
//         const saveBtn = e('button', { className: 'save-btn' }, 'Save song');
//         const likeBtn = e('button', { className: 'like-btn' }, 'Like song');
//         const deleteBtn = e('button', { className: 'delete-btn' }, 'Delete');

//         const div = e('div', { className: 'hits-info' },
//             e('img', { src: './static/img/img.png' }),
//             e('h2', {}, `Genre: ${genre}`),
//             e('h2', {}, `Name: ${song}`),
//             e('h2', {}, `Author: ${author}`),
//             e('h3', {}, `Date: ${date}`),
//             saveBtn,
//             likeBtn,
//             deleteBtn
//         );

//         divAllHits.appendChild(div);

//         likeBtn.addEventListener('click', () => {
//             totalLikes += 1;
//             likeBtn.disabled = true;
//             let likesCounter = document.querySelector('#total-likes p');
//             likesCounter.textContent = `Total Likes: ${totalLikes}`;
//         });

//         saveBtn.addEventListener('click', () => {
//             const divSavedHit = document.querySelector('.saved-container');
//             divSavedHit.appendChild(div);
//             saveBtn.remove();
//             likeBtn.remove();
//         });

//         deleteBtn.addEventListener('click', () => {
//             div.remove();
//         });
//     }

//     function e(type, attributes, ...content) {
//         const result = document.createElement(type);

//         for (let [attr, value] of Object.entries(attributes || {})) {
//             if (attr.substring(0, 2) == 'on') {
//                 result.addEventListener(attr.substring(2).toLocaleLowerCase(), value);
//             } else {
//                 result[attr] = value;
//             }
//         }

//         content = content.reduce((a, c) => a.concat(Array.isArray(c) ? c : [c]), []);

//         content.forEach(e => {
//             if (typeof e == 'string' || typeof e == 'number') {
//                 const node = document.createTextNode(e);
//                 result.appendChild(node);
//             } else {
//                 result.appendChild(e);
//             }
//         });

//         return result;
//     }
// }


// fourth option


// function solve() {
//     const fields = document.querySelectorAll('.container-text input');
//     const addButton = document.querySelector('.container-text button');
//     const allHits = document.querySelector('#all-hits div');
//     const savedHits = document.querySelector('#saved-hits div');
//     const totalLikes = document.querySelector('#total-likes div');

//     const input = {
//         genre: fields[0],
//         name: fields[1],
//         author: fields[2],
//         date: fields[3],
//     }

//     addButton.addEventListener('click', (event) => {
//         event.preventDefault();

//         const genre = input.genre.value.trim();
//         const name = input.name.value.trim();
//         const author = input.author.value.trim();
//         const date = input.date.value.trim();

//         if (genre == '' || name == '' || author == '' || date == '') {
//             return;
//         }

//         const divEl = e('div', ``, 'hits-info');
//         const imgEl = e('img', './static/img/img.png');
//         const genreEl = e('h2', `Genre: ${genre}`);
//         const nameEl = e('h2', `Name: ${name}`);
//         const authorEl = e('h2', `Author: ${author}`);
//         const dateEl = e('h3', `Date: ${date}`);
//         const saveSongBtn = e('button', 'Save song', 'save-btn');
//         const likeSongBtn = e('button', 'Like song', 'like-btn');
//         const deleteSongBtn = e('button', 'Delete', 'delete-btn');

//         divEl.appendChild(imgEl);
//         divEl.appendChild(genreEl);
//         divEl.appendChild(nameEl);
//         divEl.appendChild(authorEl);
//         divEl.appendChild(dateEl);
//         divEl.appendChild(saveSongBtn);
//         divEl.appendChild(likeSongBtn);
//         divEl.appendChild(deleteSongBtn);

//         allHits.appendChild(divEl);

//         input.genre.value = '';
//         input.name.value = '';
//         input.author.value = '';
//         input.date.value = '';

//         likeSongBtn.addEventListener('click', () => {
//             let pEl = totalLikes.querySelector('p').textContent;
//             let newLikes = Number(pEl.slice(-1)) + 1;
//             totalLikes.querySelector('p').textContent = pEl.substr(0, pEl.length - 1) + newLikes;
//             likeSongBtn.disabled = true;

//         })

//         saveSongBtn.addEventListener('click', () => {
//             const saveSongDivEl = e('div', ``, 'hits-info');
//             saveSongDivEl.appendChild(imgEl);
//             saveSongDivEl.appendChild(genreEl);
//             saveSongDivEl.appendChild(nameEl);
//             saveSongDivEl.appendChild(authorEl);
//             saveSongDivEl.appendChild(dateEl);
//             saveSongDivEl.appendChild(deleteSongBtn);

//             savedHits.appendChild(saveSongDivEl);
//             saveSongBtn.parentNode.parentNode.removeChild(divEl);;

//         })

//         deleteSongBtn.addEventListener('click', () => {
//             let divForDelete = deleteSongBtn.parentNode;
//             deleteSongBtn.parentNode.parentNode.removeChild(divForDelete);

//             let pEl = totalLikes.querySelector('p').textContent;
//             let newLikes = Number(pEl.slice(-1)) - 1;
//             totalLikes.querySelector('p').textContent = pEl.substr(0, pEl.length - 1) + newLikes;
//         })


//     })

//     function e(type, content, className) {
//         let element = document.createElement(type);

//         if (type === 'img') {
//             element.src = content;
//         } else {
//             element.textContent = content;
//         }

//         if (className) {
//             element.className = className;
//         }

//         return element;
//     }
// }
