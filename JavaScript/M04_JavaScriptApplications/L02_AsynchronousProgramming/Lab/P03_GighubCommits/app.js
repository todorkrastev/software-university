function loadCommits() {
    const username = document.querySelector('#username');
    const repo = document.querySelector('#repo');
    const url = `https://api.github.com/repos/${username.value}/${repo.value}/commits`;
    let list = document.querySelector('#commits');

    function _createLi(_text) {
        let li = document.createElement('li');
        li.textContent = _text;
        list.appendChild(li);
    }
    
    let status;
    fetch(url)
        .then(response => {
            if (response.status.ok == false) {
                status = response.status;
            }
            return response.json();
        })
        .then(data => {
            list.innerHTML = '';
            if (data.message === 'Not Found') {
                _createLi(`Error:${status} (${data.message})`);
                return;
            }
            data.forEach(e => {
                _createLi(`${e.commit.author.name}: ${e.commit.message}`);
            });
        });

    document.querySelector('#username').value = '';
    document.querySelector('#repo').value = '';



    // second option


    // const html = {
    //     nameField: document.getElementById(`username`),
    //     repoField: document.getElementById(`repo`),
    //     resultE: document.getElementById(`commits`),
    // };

    // html.resultE.innerHTML = '';

    // const eFactory = (tag, content = '') => {
    //     const e = document.createElement(tag);
    //     e.innerHTML = content;

    //     return e;
    // };

    // try {
    //     const data = await fetch(`https://api.github.com/repos/${html.nameField.value}/${html.repoField.value}/commits`);

    //     if (!data.ok) throw new Error(`${data.status} (${data.statusText})`);

    //     const deserialized = await data.json();

    //     deserialized.forEach(({ commit }) => html.resultE.appendChild(eFactory(
    //         'li',
    //         `${commit.author.name}: ${commit.message}`
    //     )))

    // } catch (e) {
    //     html.resultE.appendChild(eFactory('li', e));
    // }
}
