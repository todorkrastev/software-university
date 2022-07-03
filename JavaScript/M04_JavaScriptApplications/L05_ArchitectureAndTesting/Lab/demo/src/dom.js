const main = document.querySelector('main');

export function showSection(section){
  main.replaceChildren(section);
}

export function e(type, attributes, ...content) {
  const result = document.createElement(type);

  for (let [attr, value] of Object.entries(attributes || {})) {
      if (attr.substring(0, 2) == 'on') {
          result.addEventListener(attr.substring(2).toLocaleLowerCase(), value);
      } else if (attr.substring(0, 3) == 'set') {
          result.setAttribute(attr.substring(3).toLocaleLowerCase(), value);
      } else {
          if (typeof value == 'object') {
              for (let [subAttr, subValue] of Object.entries(value)) {
                  result[attr][subAttr] = subValue;
              }
          } else {
              result[attr] = value;
          }
      }
  }

  content = content.reduce((a, c) => a.concat(Array.isArray(c) ? c : [c]), []);

  content.forEach(e => {
      if (typeof e == 'string' || typeof e == 'number') {
          const node = document.createTextNode(e);
          result.appendChild(node);
      } else {
          result.appendChild(e);
      }
  });

  return result;
}