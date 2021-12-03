import { html } from '../lib.js';
import { getAllGames } from "../api/data.js";


const catalogTemplate = (games) => html`
<section id="catalog-page">
    <h1>All Games</h1>
    <!-- Display div: with information about every game (if any) -->
    <!-- Display paragraph: If there is no games  -->
    ${games.length == 0 ? html`<h3 class="no-articles">No articles yet</h3>` : games.map(gamePreview)}
</section>
`;

const gamePreview = (game) => html`
<div class="allGames">
    <div class="allGames-info">
        <img src=${game.imageUrl}">
        <h6>${game.category}</h6>
        <h2>${game.title}</h2>
        <a href="/details/${game._id}" class="details-button">Details</a>
    </div>
</div>
`;

export async function catalogPage(ctx) {
    const games = await getAllGames();
    ctx.render(catalogTemplate(games));
}