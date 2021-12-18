import { html } from '../../node_modules/lit-html/lit-html.js';
import { getArticlesBySearchTitle } from '../data/requests.js';






const template = (articles, onSearch) => html`
<section id="searchPage">
<h1>Search by Name</h1>

<div class="search">
    <form id="search-form" @submit=${onSearch}>
        <input id="search-input" type="text" name="search" placeholder="Enter desired albums's name">
        <button class="button-list">Search</button>
    </div>
</form>
<h2>Results:</h2>
<div class="search-result">
        ${articles.length > 0 ?
            articles.map(articleTemplate) :
            html` <p class="no-result">No result.</p>`}
        
    </div>
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




export const searchPage = async (ctx) => {
    const title = ctx.querystring.split('=')[1];
    let articles = [];
    if (title) {
        articles = await getArticlesBySearchTitle(title);
    }
    console.log(articles);
    ctx.render(template(articles, onSearch));

    function onSearch(e) {
        e.preventDefault();
        const formData = new FormData(e.target);
        const title = formData.get('search');
        ctx.page.redirect('/search?title=' + title);
    }
}

function isLogged(){
    if (!sessionStorage.getItem('userData')) {
        return false;
    } 
    return true;
}