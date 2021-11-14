import { loadHomePage } from './home.js';

let id;

export async function createNewTopic(event) {
    event.preventDefault();
    const form = event.target.parentNode.parentNode;

    const formData = new FormData(form);
    const title = formData.get('topicName');
    const username = formData.get('username');
    const postText = formData.get('postText');
    const time = new Date().toLocaleString();

    if (title == '' || username == '' || postText == '') {
        return alert('All field must be filled!');
    }

    const response = await fetch('http://localhost:3030/jsonstore/collections/myboard/posts', {
        method: 'post',
        headers: { 'Content-Type': 'applicaton/json' },
        body: JSON.stringify({ title, username, postText, time })
    });

    if (response.ok == false) {
        const error = await response.json();
        return alert(error.message);
    } else {
        loadHomePage();
    }

    form.reset();
}

export async function loadTopic(postId) {
    const main = document.querySelector('main');
    id = postId;
    const postResponse = await fetch('http://localhost:3030/jsonstore/collections/myboard/posts/' + id);
    const data = await postResponse.json();
    const title = data.title;
    const time = data.time;
    const username = data.username;
    const postText = data.postText;

    const fragment = document.createDocumentFragment();
    fragment.appendChild(createTitle(title, time));

    //add initial post text
    fragment.appendChild(createComment(username, time, postText));

    const comments = await loadTopicComments(id);
    comments.forEach(c => fragment.appendChild(c));

    fragment.appendChild(addCommentSection());

    main.innerHTML = '';
    main.appendChild(fragment);
}

function createTitle(title, time) {
    const divTopic = document.createElement('div');
    divTopic.className = 'topic-content';
    divTopic.innerHTML = `
    <div class="theme-title">
   <div class="theme-name-wrapper">
       <div class="theme-name">
           <h2>${title}</h2>
           <p>Date: <time>${time}</time></p>
       </div>
   </div>
    </div>`;
    return divTopic;
}

function createComment(username, time, text) {
    const divComment = document.createElement('div');
    divComment.className = 'comment';
    divComment.innerHTML = `
    <header class="header">
    <p><span>${username}</span> posted on <time>${time}</time></p>
    </header>
    <div class="comment-main">
    <div class="userdetails">
        <img src="./static/profile.png" alt="avatar">
    </div>
    <div class="post-content">
        <p>${text}</p>
    </div>
    </div>`;
    return divComment;
}

function addCommentSection() {
    const divComment = document.createElement('div');
    divComment.className = 'answer-comment';
    divComment.innerHTML = `
    <p><span>currentUser</span> comment:</p>
    <div class="answer">
        <form>
            <textarea name="postText" id="comment" cols="30" rows="10"></textarea>
            <div>
                <label for="username">Username <span class="red">*</span></label>
                <input type="text" name="username" id="username">
            </div>
            <button>Post</button>
        </form>
    </div>`;

    divComment.querySelector('form').addEventListener('submit', onSubmit);

    return divComment;
}

async function onSubmit(event) {
    event.preventDefault();

    const formData = new FormData(event.target);
    const text = formData.get('postText');
    const username = formData.get('username');
    const time = new Date().toLocaleString();

    const response = await fetch('http://localhost:3030/jsonstore/collections/myboard/comments', {
        method: 'post',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ postId: id, text, username, time })
    });

    if (response.ok == false) {
        const error = await response.json();
        return alert(error.message);
    } else {
        loadTopic(id);
    }
}

async function loadTopicComments(id) {
    const commentsResponse = await fetch('http://localhost:3030/jsonstore/collections/myboard/comments');
    const allComments = await commentsResponse.json();
    const comments = Object.values(allComments)
        .filter(c => c.postId == id)
        .map(c => createComment(c.username, c.time, c.text));
    return comments;
}
