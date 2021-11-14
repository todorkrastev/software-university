import { createTopic, getComments, getPosts, postComment } from './requests.js';
import { createCommentsElement, createPostsElement } from './display.js';
import { isValidData, clearFormFields } from './helper.js';

const main = document.querySelector('main');
const displayPosts = createPostsElement.bind(undefined, main);
const displayComments = createCommentsElement.bind(undefined, main);
let post = ''

displayPosts(await getPosts());

document.addEventListener('submit', async e => {
	e.preventDefault();
	const formData = new FormData(e.target);
	const deserializedData = Object.fromEntries([...formData.entries()]);

	const forms = {
		'postForm': async e => {
			if (e.submitter.className === 'public') {
				if (isValidData(deserializedData)) {
					await createTopic(deserializedData, Date.now());
					displayPosts(await getPosts());
				} else {
					alert('Missing fields!');
					return;
				}
			}

			clearFormFields(e.target);
		},
		'commentForm': async () => {
			await postComment({ ...deserializedData, creationDate: Date.now() }, post.topicName);
			displayComments(post, await getComments(post.topicName));
		}
	}

	forms[e.target.id](e);
})

document.addEventListener('click', async e => {
	if (e.target.tagName === 'H2' && e.path[1].className === 'normal') {
		const postName = e.target.textContent;
		const posts = await getPosts();
		post = posts.find(x => x.topicName === postName);
		const comments = await getComments(postName);

		displayComments(post, comments);
	}
	if (e.target.tagName === 'A' && e.target.textContent === 'Home') {
		displayPosts(await getPosts());
	}
});
