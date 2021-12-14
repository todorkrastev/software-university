import { createRecipe } from '../api/recipe.js';
import { html } from '../lib.js';
import { createSubmitHandler } from '../util.js';
import { errorMsg, field } from './common.js';


const createTemplate = (onSubmit, errors, data) => html`
<section id="create">
    <article>
        <h2>New Recipe</h2>
        <form @submit=${onSubmit} id="createForm">
            ${errorMsg(errors)}

            ${field({ label: 'Name', name: 'name', placeholder: 'Recipe name', value: data.name, error: errors.name })}
            ${field({ label: 'Image', name: 'img', placeholder: 'Image URL', value: data.img, error: errors.img })}
            ${field({
                label: 'Ingredients',
                type: 'textarea',
                name: 'ingredients',
                placeholder: 'Enter ingredients on separate lines',
                value: data.ingredients,
                error: errors.ingredients })}
            ${field({
                label: 'Preparation',
                type: 'textarea',
                name: 'steps',
                placeholder: 'Enter preparation steps on separate lines',
                value: data.steps,
                error: errors.steps })}
            <input type="submit" value="Create Recipe">
        </form>
    </article>
</section>`;

export function createPage(ctx) {
    update();

    function update(errors = {}, data = {}) {
        ctx.render(createTemplate(createSubmitHandler(onSubmit, 'name', 'img', 'ingredients', 'steps'), errors, data));
    }

    async function onSubmit(data, event) {
        try {
            const missing = Object.entries(data).filter(([k, v]) => v == '');

            if (missing.length > 0) {
                throw missing.reduce((a, [k]) => Object.assign(a, { [k]: true }), { message: 'Please fill all fields!' }); 
            }

            const recipe = {
                name: data.name,
                img: data.img,
                ingredients: data.ingredients.split('\n').filter(r => r != ''),
                steps: data.steps.split('\n').filter(r => r != '')
            };

            const result = await createRecipe(recipe);
            event.target.reset();
            ctx.page.redirect('/details/' + result.objectId);
        } catch (err) {
            update(err, data);
        }
    }
}