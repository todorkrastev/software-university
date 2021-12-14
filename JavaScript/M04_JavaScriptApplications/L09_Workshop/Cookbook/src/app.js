import { page } from './lib.js';
import decorateContext from './middlewares/render.js';
import addSession from './middlewares/session.js';
import notify from './middlewares/notify.js';
import { homePage } from './views/home.js';
import { loginPage } from './views/login.js';
import { registerPage } from './views/register.js';
import { catalogPage } from './views/catalog.js';
import { createPage } from './views/create.js';
import { detailsPage } from './views/details.js';
import { editPage } from './views/edit.js';

page(decorateContext());
page(addSession());
page(notify());
page('/', homePage);
page('/catalog', catalogPage);
page('/details/:id', detailsPage);
page('/login', loginPage);
page('/register', registerPage);
page('/create', createPage);
page('/edit/:id', editPage);

page.start();