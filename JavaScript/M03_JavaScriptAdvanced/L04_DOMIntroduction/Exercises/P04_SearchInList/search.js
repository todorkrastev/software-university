function search() {
   const towns = Array.from(document.querySelectorAll('ul li'));
   const searcher = document.getElementById('searchText').value;
   let counter = 0;

   towns.forEach((town) => {
      if (town.innerHTML.includes(searcher)) {
         town.style.fontWeight = 'bold';
         town.style.textDecoration = 'underline';
         counter++;
      } else {
         town.style.fontWeight = 'normal';
         town.style.textDecoration = '';
      }
   });
   document.getElementById('result').textContent = `${counter} matches found`;

   // second option

   // const html = {
   //    value: document.getElementById("searchText").value,
   //    data: document.getElementById("towns").children,
   //    result: document.getElementById("result"),
   // }
   // let count = 0

   // Array.from(html.data).map(x => {
   //    if (x.innerHTML.includes(html.value)) {
   //       x = x.style.textDecoration = "bold underline"
   //       count += 1
   //    }
   //    return x
   // })

   // html.result.innerHTML = `${count} matches found`
}
