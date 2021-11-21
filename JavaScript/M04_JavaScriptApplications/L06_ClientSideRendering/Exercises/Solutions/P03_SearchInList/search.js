import { html, render } from './node_modules/lit-html/lit-html.js';
import { towns as townNames } from './towns.js';

const listTemplate = (towns) => html`
<ul>
   ${towns.map(t => html`<li class=${t.match ? 'active' : '' }>${t.name}</li>`)}
</ul>
`;

const towns = townNames.map(t => ({ name: t, match: false }));
const root = document.getElementById('towns');
const input = document.getElementById('searchText');
const output = document.getElementById('result');
document.querySelector('button').addEventListener('click', onSearch);

update();

function update() {
   render(listTemplate(towns), root);
}

function onSearch() {
   const match = input.value.trim().toLocaleLowerCase();
   let matches = 0;
   for (let town of towns) {
      if (match && town.name.toLocaleLowerCase().includes(match)) {
         town.match = true;
         matches++;
      } else {
         town.match = false;
      }
   }

   output.textContent = `${matches} matches found`;

   update();
}
