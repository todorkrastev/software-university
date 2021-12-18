import { html } from '../../node_modules/lit-html/lit-html.js';

import { getArticleById, editArticle } from '../data/requests.js';

const template = (article, onSubmit) => html`
<section class="editPage">
<form id="edit" @submit=${onSubmit}>
    <fieldset>
        <legend>Edit Album</legend>

        <div class="container">
            <label for="name" class="vhide">Album name</label>
            <input id="name" name="name" class="name" type="text" .value=${article.name}>

            <label for="imgUrl" class="vhide">Image Url</label>
            <input id="imgUrl" name="imgUrl" class="imgUrl" type="text" .value=${article.imgUrl}>

            <label for="price" class="vhide">Price</label>
            <input id="price" name="price" class="price" type="text" .value=${article.price}>

            <label for="releaseDate" class="vhide">Release date</label>
            <input id="releaseDate" name="releaseDate" class="releaseDate" type="text" .value=${article.releaseDate}>

            <label for="artist" class="vhide">Artist</label>
            <input id="artist" name="artist" class="artist" type="text" .value=${article.artist}>

            <label for="genre" class="vhide">Genre</label>
            <input id="genre" name="genre" class="genre" type="text" .value=${article.genre}>

            <label for="description" class="vhide">Description</label>
            <textarea name="description" class="description" rows="10"
                cols="10" .value=${article.description}></textarea>

            <button class="edit-album" type="submit">Edit Album</button>
        </div>
    </fieldset>
</form>
</section>`;

export const editPage = async (ctx) => {
    const article = await getArticleById(ctx.params.id);
    
    ctx.render(template(article, onSubmit));

    async function onSubmit(e) {
        e.preventDefault();
        const formData = new FormData(e.target);
        const name = formData.get('name').trim();
        const imgUrl = formData.get('imgUrl').trim();
        const price = formData.get('price').trim();
        const releaseDate = formData.get('releaseDate').trim();
        const artist = formData.get('artist').trim();
        const genre = formData.get('genre').trim();
        const description = formData.get('description').trim();

        if (!name || !imgUrl || !price || !releaseDate || !artist || !genre || !description) {
            return alert('All fields are required!');
        }

        await editArticle(article._id, { name, imgUrl, price, releaseDate, artist, genre, description }, ctx.userData.token);
        ctx.page.redirect('/details/' + article._id);
    }
}