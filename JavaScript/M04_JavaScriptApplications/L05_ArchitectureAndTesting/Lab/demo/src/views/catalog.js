
import { getAllMovies } from '../api/data.js';
import { e } from "../dom.js";

const catalogSection = document.getElementById('catalogSection');
const ul = catalogSection.querySelector('ul');
catalogSection.remove();

export function showCatalogPage(ctx) {
  ctx.showSection(catalogSection);
  loadMovies();
}

async function loadMovies() {
  ul.replaceChildren('Loading...');
  const movies = await getAllMovies();
  ul.replaceChildren(...movies.map(createMovieCard));
}

function createMovieCard(movie) {
  return e('li', {}, movie.title);
}