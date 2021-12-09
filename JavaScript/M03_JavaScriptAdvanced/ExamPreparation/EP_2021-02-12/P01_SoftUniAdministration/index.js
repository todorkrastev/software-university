function solve() {
    const lectureField = document.querySelectorAll('form input')[0];
    const dateField = document.querySelectorAll('form input')[1];
    const moduleField = document.querySelector('select');
    const addBtn = document.querySelector('form button');

    addBtn.addEventListener('click', addHandler);

    function addHandler(event) {
        event.preventDefault();
        const lecture = lectureField.value;
        let date = dateField.value;
        const module = moduleField.value;

        if (lecture === '' || date === '' || module === 'Select module') {
            return;
        }

        // 2021-09-28T11:15  => 2021/09/20 - 11:15
        let formatedDate = date.split('-').join('/').split('T').join(' - ');

        const delBtn = e('button', { className: 'red' }, "Del");
        const div = document.querySelector('.modules');
        const ul = e('ul', {},);
        const li = e('li', { className: 'flex' },
            e('h4', { className: date }, `${lecture} - ${formatedDate}`),
            delBtn);
        ul.appendChild(li);

        if (document.querySelector(`.${module}`)) {
            document.querySelector(`.${module}`).parentElement.appendChild(ul);
        } else {
            const divToAttach = e('div', { className: 'module' },
                e('h3', { className: module }, `${module.toUpperCase()}-MODULE`),
                ul);
            div.appendChild(divToAttach);
        }

        const currentModule = document.querySelector(`.${module}`).parentElement;
        const lis = currentModule.querySelectorAll('li');

        Array.from(lis)
            .sort((a, b) => a.querySelector('h4').className.localeCompare(b.querySelector('h4').className))
            .forEach(x => ul.appendChild(x));


        delBtn.addEventListener('click', () => {

            const liCoumt = Array.from(currentModule.querySelectorAll('li')).length;
            if (liCoumt == 1) {
                li.parentElement.parentElement.remove();
            } else {
                li.remove();
            }
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



// second option


// function solve(e) {
//     const html = {
//         lectNameField: document.querySelectorAll(`input`)[0],
//         dateField: document.querySelectorAll(`input`)[1],
//         moduleNameField: document.getElementsByTagName('select')[0],
//         modules: document.getElementsByClassName('modules')[0]
//     };

//     const lectureTemplate = (date, lectureName) => {
//         const li = document.createElement('li');

//         li.className = 'flex';
//         li.innerHTML = `<h4>${lectureName} - ${date}</h4>
// 		<button class='red'>Del</button>`;
//         li.date = date;

//         return li;
//     }

//     const moduleTemplate = (moduleName, date, lectureName) => {
//         const moduleDiv = document.createElement('div');
//         moduleDiv.className = 'module';
//         moduleDiv.innerHTML = `<h3>${moduleName}</h3>`;

//         const moduleLectures = document.createElement('ul');
//         moduleLectures.appendChild(lectureTemplate(date, lectureName));

//         moduleDiv.appendChild(moduleLectures);

//         return moduleDiv;
//     }

//     const isValidInpit = (lectureName, date, moduleName) => lectureName !==
//         '' && date !== '' && moduleName !== 'Select module';


//     const formatDate = (s) => s.replace(/-/g, '/').replace('T', ' - ');
//     const formatName = (n) => `${n.toLocaleUpperCase()}-MODULE`;
//     const clearInput = () => {
//         html.lectNameField.value = '';
//         html.dateField.value = '';
//         html.moduleNameField.value = 'Select module';
//     };

//     document.addEventListener('click', (e) => {

//         if (e.target.tagName === 'BUTTON' && e.target.innerHTML === 'Add') {
//             e.preventDefault();
//             const [lectureName, date, moduleName] = [
//                 html.lectNameField.value,
//                 formatDate(html.dateField.value),
//                 formatName(html.moduleNameField.value)
//             ];

//             if (isValidInpit(lectureName, date, moduleName)) {
//                 const sameModule = Array.from(html.modules.children)
//                     .find(x => x.children[0].innerHTML === moduleName);

//                 if (sameModule) {
//                     const lecturesContainer = sameModule.children[1];
//                     const lectures = Array.from(lecturesContainer.children);

//                     lectures.push(lectureTemplate(date, lectureName));
//                     lectures.sort((a, b) => a.date.localeCompare(b.date));
//                     lectures.forEach(
//                         lecture => lecturesContainer.appendChild(lecture)
//                     );
//                 } else {
//                     html.modules.appendChild(moduleTemplate(
//                         moduleName,
//                         date,
//                         lectureName
//                     ))
//                 }
//                 clearInput();
//             }
//         }

//         if (e.target.tagName === 'BUTTON' && e.target.innerHTML === 'Del') {
//             const moduleSection = e.target.parentNode.parentNode.parentNode;

//             e.target.parentNode.outerHTML = '';

//             if (moduleSection.children[1].children.length === 0) {
//                 moduleSection.outerHTML = '';
//             }
//         }
//     })
// }
