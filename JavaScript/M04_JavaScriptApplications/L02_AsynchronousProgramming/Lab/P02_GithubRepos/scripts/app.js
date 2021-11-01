function loadRepos() {
	const list = document.querySelector('#repos');
	const username = document.querySelector('#username').value;
	const url = `https://api.github.com/users/${username}/repos`;

	fetch(url)
		.then(response => {
			if (response.ok == false) {
				throw new Error(`${response.status} ${response.statusText}`);
			}
			return response.json();
		})
		.then(handleResponse)
		.catch(handleError);

	function handleResponse(data) {
		list.innerHTML = '';
		for (let repo of data) {
			const liElement = document.createElement('li');
			liElement.innerHTML = ` <a href="${repo.html_url}">
			${repo.full_name}
		</a>`;
			list.appendChild(liElement);
		}
	}

	function handleError(error) {
		list.innerHTML = '';
		list.textContent = `${error.message}`;
	}



	// second option


	// const html = {
	// 	nameField: document.getElementById(`username`),
	// 	resultE: document.getElementById(`repos`)
	// };

	// const data = await fetch(`https://api.github.com/users/${html.nameField.value}/repos`);
	// const deserilized = await data.json();

	// html.resultE.innerHTML = '';

	// deserilized.forEach(({ full_name, html_url }) => {
	// 	const li = document.createElement('li');
	// 	const a = document.createElement('a');
	// 	a.innerHTML = full_name;
	// 	a.href = html_url;

	// 	li.appendChild(a);
	// 	html.resultE.appendChild(li);
	// });
}