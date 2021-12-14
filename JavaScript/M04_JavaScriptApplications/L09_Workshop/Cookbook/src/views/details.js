import { deleteRecipe, getRecipeById } from '../api/recipe.js';
import { html, until } from '../lib.js';
import { commentsView } from './comments.js';
import { spinner } from './common.js';


const detailsTemplate = (recipePromise) => html`
<section id="details">

    ${until(recipePromise, spinner())}

    <div id="comments-container"></div>
</section>`;

const recipeCard = (recipe, isOwner, onDelete) => html`
<article>
    <h2>${recipe.name}</h2>
    <div class="band">
        <div class="thumb"><img src=${recipe.img}></div>
        <div class="ingredients">
            <h3>Ingredients:</h3>
            <ul>
                ${recipe.ingredients.map(i => html`<li>${i}</li>`)}
            </ul>
        </div>
    </div>
    <div class="description">
        <h3>Preparation:</h3>
        ${recipe.steps.map(i => html`<p>${i}</p>`)}
    </div>
    ${isOwner ? 
    html`<div class="controls">
        <a class="actionLink" href="/edit/${recipe.objectId}">&#x270e; Edit</a>
        <a @click=${onDelete} class="actionLink" href="javascript:void(0)">&#x2716; Delete</a>
    </div>` : null}
</article>`;

export function detailsPage(ctx) {
    ctx.render(detailsTemplate(loadRecipe(ctx)));
    commentsView(ctx, ctx.params.id);
}

async function loadRecipe(ctx) {
    const recipe = await getRecipeById(ctx.params.id);
    const isOwner = ctx.user && ctx.user.id == recipe.owner.objectId;

    return recipeCard(recipe, isOwner, onDelete);

    async function onDelete() {
        const choice = confirm('Are you sure you want to delete this recipe?');

        if (choice) {
            await deleteRecipe(ctx.params.id);
            ctx.notify('Recipe deleted');
            ctx.page.redirect('/catalog');
        }
    }
}