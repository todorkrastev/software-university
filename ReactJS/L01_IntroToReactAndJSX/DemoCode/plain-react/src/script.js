let rootElement = document.getElementById("root");

/*
let reactElement = React.createElement(
    'header',
    { className: 'header'},
    React.createElement('h1', { className: 'header__main' }, 'Hello React'),
    React.createElement('h2', { className: 'header__secondary' }, 'The best framework in the world!')
);
*/

let reactElement = (
  <div>
    <header>
      <h1>Hello JSX Modified</h1>
      <h2>The best framework in the world!</h2>

      <p>I am just a simple paragraph</p>

      <footer>All rights reserved &copy;</footer>
    </header>
  </div>
);

ReactDOM.render(reactElement, rootElement);
