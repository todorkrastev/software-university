import { getRecipes } from '../api/recipe.js';
import { html, until } from '../lib.js';
import { createSubmitHandler, parseQuery } from '../util.js';
import { spinner } from './common.js';


const catalogTemplate = (recipePromise, onSearch, pager, search = '') => html`
<section id="catalog">
    <div class="section-title">
        <form @submit=${onSearch} id="searchForm">
            <input type="text" name="search" .value=${search}>
            <input type="submit" value="Search">
        </form>
    </div>

    <header class="section-title">
        ${until(pager(), spinner())}
    </header>

    ${until(recipePromise, spinner())}

    <footer class="section-title">
        ${until(pager(), spinner())}
    </footer>

</section>`;

const recipePreview = (recipe) => html`
<a class="card" href="/details/${recipe.objectId}">
    <article class="preview">
        <div class="title">
            <h2>${recipe.name}</h2>
        </div>
        <div class="small"><img src=${recipe.img}></div>
    </article>
</a>`;

function pagerSetup(page, recipesPromise, search) {
    return async () => {
        const { pages } = await recipesPromise;

        return html`
            Page ${page} of ${pages}
            ${page > 1 ? html`<a class="pager" href=${'/catalog/' + createQuery(page - 1, search)}>&lt;
                Prev</a>` : ''}
            ${page < pages ? html`<a class="pager" href=${'/catalog/' + createQuery(page + 1, search)}>Next
                &gt;</a>` : ''}`;
    };
}

function createQuery(page, search) {
    return `?page=${page}${(search ? `&search=${search}` : '')}`;
}

export function catalogPage(ctx) {
    const { page, search } = parseQuery(ctx.querystring);
    const recipesPromise = getRecipes(page || 1, search || '');

    ctx.render(catalogTemplate(loadRecipes(recipesPromise), createSubmitHandler(onSearch, 'search'), pagerSetup(page || 1, recipesPromise, search), search));

    function onSearch({ search }) {
        if (search) {
            ctx.page.redirect(`/catalog?search=${encodeURIComponent(search)}`);
        } else {
            ctx.page.redirect('/catalog');
        }
    }
}

async function loadRecipes(recipesPromise) {
    const { results: recipes } = await recipesPromise;

    if (recipes.length == 0) {
        return html`<p>No recipes found. Be the first to post a recipe!</p>`;
    } else {
        return recipes.map(recipePreview);
    }
}