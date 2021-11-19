import { deleteById, getById } from '../api/data.js';
import { e } from '../dom.js';

const section = document.getElementById('detailsPage');
section.remove();
let ctx = null;

export async function showDetailsPage(ctxTarget, id) {
    ctx = ctxTarget;
    ctx.showSection(section);
    loadIdea(id);
}

async function loadIdea(id) {
    const idea = await getById(id);

    section.replaceChildren(createIdeaDiv(idea));
}

function createIdeaDiv(idea) {
    const fragment = document.createDocumentFragment();

    fragment.appendChild(e('img', { className: 'det-img', src: idea.img }));
    fragment.appendChild(e('div', { className: 'desc' },
        e('h2', { className: 'display-5' }, idea.title),
        e('p', { className: 'infoType' }, 'Description:'),
        e('p', { className: 'idea-description' }, idea.description)),
    );

    const userData = JSON.parse(sessionStorage.getItem('userData'));
    if (userData && userData.id == idea._ownerId) {
        fragment.appendChild(e('div', { className: 'text-center' },
            e('a', { className: 'btn detb', href: '', onClick: onDelete }, 'Delete')
        ));
    }

    return fragment;

    async function onDelete(event) {
        event.preventDefault();
        const confirmed = confirm('Are you sure you want to delete this idea?');
        if (confirmed) {
            await deleteById(idea._id);
            ctx.goTo('catalog');
        }
    }
}

/*
<img class="det-img" src="./images/dinner.jpg" />
<div class="desc">
    <h2 class="display-5">Dinner Recipe</h2>
    <p class="infoType">Description:</p>
    <p class="idea-description">There are few things as comforting as heaping bowl of pasta at the end of a
        long
        day. With so many easy pasta recipes out there, there's something for every palate to love. That's
        why
        pasta
        makes such a quick, easy dinner for your family—it's likely to satisfy everyone's cravings, due to
        its
        versatility.</p>
</div>
<div class="text-center">
    <a class="btn detb" href="">Delete</a>
</div>
 */