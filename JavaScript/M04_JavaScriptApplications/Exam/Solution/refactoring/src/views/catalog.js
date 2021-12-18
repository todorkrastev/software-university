import { html } from '../../node_modules/lit-html/lit-html.js';

import { getArticles } from '../data/requests.js';

const template = (articles) => html`
<section id="catalogPage">
<h1>All Albums</h1>
    ${articles.length > 0 ?
    articles.map(articleTemplate) :
    html`<p>No Albums in Catalog!</p>`}
</section>`;

const articleTemplate = (article) => html`
<div class="card-box">
                <img src="${article.imgUrl}">
                <div>
                    <div class="text-center">
                        <p class="name">Name: ${article.name}</p>
                        <p class="artist">Artist: ${article.artist}</p>
                        <p class="genre">Genre: ${article.genre}</p>
                        <p class="price">Price: $${article.price}</p>
                        <p class="date">Release Date: ${article.releaseDate}</p>
                    </div>
                    <div class="btn-group">
                    ${isLogged() ? html`
                    <a href="/details/${article._id}" id="details">Details</a>` : ''}   
                    </div>
                </div>
            </div>`;


export const catalogPage = async (ctx) => {
    const articles = await getArticles();
    ctx.render(template(articles));
};

function isLogged(){
    if (!sessionStorage.getItem('userData')) {
        return false;
    } 
    return true;
}