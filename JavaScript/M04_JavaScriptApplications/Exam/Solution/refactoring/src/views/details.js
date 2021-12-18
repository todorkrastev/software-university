import { html } from '../../node_modules/lit-html/lit-html.js';

import { getArticleById, deleteArticle as delArticle } from '../data/requests.js';

const template = (article, isOwner, deleteArticle) => html`
<section id="detailsPage">
            <div class="wrapper">
                <div class="albumCover">
                    <img src="${article.imgUrl}">
                </div>
                <div class="albumInfo">
                    <div class="albumText">

                        <h1>Name: ${article.name}</h1>
                        <h3>Artist: ${article.artist}</h3>
                        <h4>Genre: ${article.genre}</h4>
                        <h4>Price: $${article.price}</h4>
                        <h4>Date: ${article.releaseDate}</h4>
                        <p>Description: ${article.description}.</p>
                    </div>

                    <!-- Only for registered user and creator of the album-->
                    <div class="actionBtn">
                    ${isOwner ? html`
                        <a href="/edit/${article._id}" class="edit">Edit</a>
                        <a @click=${deleteArticle} href="javascript:void(0)" class="remove">Delete</a>` : ''}   
                    </div>
                </div>
            </div>
        </section>`;

export const detailsPage = async (ctx) => {
    console.log('tukaa');
    const article = await getArticleById(ctx.params.id);
    let isOwner = false;
    if (ctx.userData) {
        isOwner = article._ownerId === ctx.userData.id;
    }
    ctx.render(template(article, isOwner, deleteArticle));

    async function deleteArticle() {
        const confirmed = confirm('Are you sure?');
        if (confirmed) {
            await delArticle(article._id, ctx.userData.token);
            ctx.page.redirect('/');
        }
    }

    
}