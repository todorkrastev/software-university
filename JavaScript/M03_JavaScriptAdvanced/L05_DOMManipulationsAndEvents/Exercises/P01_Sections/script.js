function create(words) {
   const content = document.getElementById('content');

   for (const word of words) {
      const div = document.createElement('div');
      const p = document.createElement('p');
      p.textContent = word;
      p.style.display = 'none';
      div.appendChild(p);

      div.addEventListener('click', reveal);

      content.appendChild(div);

      function reveal(ev) {
         ev.currentTarget.children[0].style.display = ''; // or firstChildren instead of children[0]
      }
   }

   // a modification of the first option -> using DOM Event Delegation

   // const content = document.getElementById('content');
   // content.addEventListener('click', reveal);

   // for (let word of words) {
   //    const div = document.createElement('div');
   //    const p = document.createElement('p');
   //    p.textContent = word;
   //    p.style.display = 'none';
   //    div.appendChild(p);

   //    content.appendChild(div);

   // }
   // function reveal(ev) {
   //    if (ev.target.tagName == 'DIV' && ev.target != content) {
   //       ev.target.children[0].style.display = '';
   //    }
   // }

   // second option

   // const elements = []
   // const output = document.getElementById("content")

   // function eFactory(tag, content = "") {
   //    const temp = document.createElement(tag)
   //    temp.innerHTML = content

   //    return temp
   // }

   // arr.forEach(x => {
   //    const div = eFactory("div")
   //    const p = eFactory("p", x)
   //    p.style.display = "none"

   //    div.appendChild(p)
   //    div.addEventListener("click", () => (p.style.display = "block"))
   //    elements.push(div)
   // })

   // elements.forEach(x => output.appendChild(x))
}
