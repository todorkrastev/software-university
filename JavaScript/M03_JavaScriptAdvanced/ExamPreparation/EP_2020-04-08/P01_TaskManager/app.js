function solve() {
    const addButton = document.querySelector('#add');
    addButton.addEventListener('click', addTask);
    let openSection = document.querySelector('.wrapper > section:nth-of-type(2) > div:nth-of-type(2)');

    function addTask(event) {
        event.preventDefault();

        let task = document.querySelector('#task');
        let description = document.querySelector('#description');
        let date = document.querySelector('#date');

        if (task.value !== '' && description.value !== '' && date.value !== '') {
            let article = document.createElement('article');

            let taskHeading3 = document.createElement('h3');
            taskHeading3.textContent = task.value.trim();
            article.appendChild(taskHeading3);

            let descriptionParagraph = document.createElement('p');
            descriptionParagraph.textContent = `Description: ${description.value.trim()}`;
            article.appendChild(descriptionParagraph);

            let dateParagraph = document.createElement('p');
            dateParagraph.textContent = `Due Date: ${date.value.trim()}`;
            article.appendChild(dateParagraph);

            let buttonsDiv = document.createElement('div');
            buttonsDiv.classList.add('flex');

            let startButton = document.createElement('button');
            startButton.classList.add('green');
            startButton.textContent = 'Start';
            buttonsDiv.appendChild(startButton);

            let deleteButton = document.createElement('button');
            deleteButton.classList.add('red');
            deleteButton.textContent = 'Delete';
            buttonsDiv.appendChild(deleteButton);

            article.appendChild(buttonsDiv);
            openSection.appendChild(article);

            startButton.addEventListener('click', addInProgress);
            deleteButton.addEventListener('click', deleteTask);
        }
        
        task.value = '';
        description.value = '';
        date.value = '';
    }

    function addInProgress() {
        let inProgress = document.querySelector('#in-progress');
        let deleteBtn = this.nextElementSibling;
        deleteBtn.addEventListener('click', deleteTask);
        let article = this.parentElement.parentElement;
        let buttons = this.parentElement;
        let startBtn = this.parentElement.firstElementChild;
        buttons.removeChild(startBtn);

        let finishButton = document.createElement('button');
        finishButton.classList.add('orange');
        finishButton.textContent = 'Finish';
        article.querySelector('.flex').appendChild(finishButton);

        finishButton.addEventListener('click', completeTask);
        inProgress.appendChild(article);
    }

    function deleteTask() {
        this.parentElement.parentElement.remove();
    }

    function completeTask() {
        let article = this.parentElement.parentElement;
        let buttons = this.parentElement;
        buttons.remove();

        let completedTask = document.querySelector('.wrapper > section:nth-of-type(4) > div:nth-of-type(2)');
        completedTask.appendChild(article);
    }
}



// second option


// function solve () {
// 	const inputFields = [
// 		document.getElementById(`task`),
// 		document.getElementById(`description`),
// 		document.getElementById(`date`),
// 	]

// 	const sections = Array.from(document.getElementsByTagName('section'))
// 		.slice(1)
// 		.map(x => x.children[1])

// 	function articleTemplFactory (b, c, b1, c1, n, d, da) {
// 		const article = document.createElement('article')

// 		article.innerHTML = `<h3>${n}</h3><p>${d}</p>
// <p>${da}</p>`

// 		article.innerHTML += b !== ''
// 			? `<div class="flex">
// <button class=${c}>${b}</button>
// <button class=${c1}>${b1}</button>
// </div>`
// 			: ''

// 		return article
// 	}

// 	const isValidInput = (arr) => arr.every(x => x !== '')
// 	const clearInput = (arr) => arr.forEach(x => x.value = '')
// 	const remove = (e) => e.parentNode.parentNode.outerHTML = ''

// 	const appendNewItem = (s, b, c, b1, c1, n, d, da) =>
// 		s.appendChild(articleTemplFactory(b, c, b1, c1, n, d, da))

// 	const add = appendNewItem.bind(undefined, sections[0], 'Start', 'green', 'Delete', 'red',)
// 	const start = appendNewItem.bind(undefined, sections[1], 'Delete', 'red', 'Finish', 'orange',)
// 	const finish = appendNewItem.bind(undefined, sections[2], '', '', '', '')

// 	document.addEventListener('click', (e) => {
// 		if (e.target.tagName === 'BUTTON') {
// 			e.preventDefault()

// 			const action = e.target.className
// 			const values = inputFields.map(x => x.value)

// 			const workValues = [values[0], `Description: ${values[1]}`, `Due Date: ${values[2]}`]

// 			const getData = () =>
// 				Array.from(e.target.parentNode.parentNode.children)
// 					.map(x => x.innerHTML)

// 			const actions = {
// 				'': () => {
// 					if (isValidInput(values)) {
// 						add(...workValues)
// 						clearInput(inputFields)
// 					}
// 				},
// 				'green': () => {
// 					start(...getData())
// 					remove(e.target)
// 				},
// 				'orange': () => {
// 					finish(...getData())
// 					remove(e.target)
// 				},
// 				'red': () => remove(e.target)
// 			}

// 			actions[action]()
// 		}
// 	})
// }
