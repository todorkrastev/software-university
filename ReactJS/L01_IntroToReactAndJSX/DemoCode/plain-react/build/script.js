var rootElement = document.getElementById("root");

/*
let reactElement = React.createElement(
    'header',
    { className: 'header'},
    React.createElement('h1', { className: 'header__main' }, 'Hello React'),
    React.createElement('h2', { className: 'header__secondary' }, 'The best framework in the world!')
);
*/

var reactElement = React.createElement(
  "div",
  null,
  React.createElement(
    "header",
    null,
    React.createElement(
      "h1",
      null,
      "Hello JSX Modified"
    ),
    React.createElement(
      "h2",
      null,
      "The best framework in the world!"
    ),
    React.createElement(
      "p",
      null,
      "I am just a simple paragraph"
    ),
    React.createElement(
      "footer",
      null,
      "All rights reserved \xA9"
    )
  )
);

ReactDOM.render(reactElement, rootElement);