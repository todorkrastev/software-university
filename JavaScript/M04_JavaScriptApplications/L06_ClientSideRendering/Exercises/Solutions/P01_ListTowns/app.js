import { html, render } from "./node_modules/lit-html/lit-html.js";

const root = document.getElementById('root');
document.querySelector('form').addEventListener('submit', (event) => {
    event.preventDefault();
    const townsID = document.getElementById('towns');
    const towns = townsID.value.split(',').map(t => t.trim());

    if (towns != '') {
        const result = listTemplate(towns);
        render(result, root);
    }
    townsID.value = '';
});

const listTemplate = (towns) => html`
<ul>
    ${towns.map(t => html`<li>${t}</li>`)}
</ul>
`;
