function solve() {
   document.querySelector('#searchBtn').addEventListener('click', onClick);

   function onClick() {
      const input = document.getElementById('searchField');
      let inputText = input.value.toLowerCase();
      let tableElements = Array.from(document.querySelectorAll('tbody tr'));

      tableElements.forEach((el) => {
         let text = el.textContent.toLowerCase();
         if (text.includes(inputText)) {
            el.classList.add('select');
         } else {
            el.classList.remove('select');
         }
      })
      input.value = '';
   }

   // second option

   // const data = {
   //    collection: document.getElementsByTagName("tr"),
   //    getValue: () => document.getElementById("searchField").value,
   // }

   // function onClick({ collection, value }) {
   //    collection.map(x => (x.className = ""))
   //    collection.map(x => {
   //       if (x.innerHTML.includes(value)) x.className = "select"

   //       return x
   //    })
   // }

   // document.getElementById("searchBtn").addEventListener("click", () =>
   //    onClick({
   //       collection: Array.from(data.collection),
   //       value: data.getValue(),
   //    })
   // )
}