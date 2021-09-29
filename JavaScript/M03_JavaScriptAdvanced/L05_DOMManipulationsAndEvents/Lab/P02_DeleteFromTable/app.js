function deleteByEmail() {
    const input = document.querySelector('input[name="email"]');
    const rows = Array.from(document.querySelector('tbody').children);
    let result = document.getElementById('result');

    for (const row of rows) {
        if (row.children[1].textContent == input.value) {
            row.remove();
            result.innerHTML = 'Deleted';
        }
    }

    if (result.innerHTML !== 'Deleted') {
        result.innerHTML = 'Not found.';
    }

    // optimization of the first option 
    
    // const input = document.querySelector('input[name="email"]');
    // const rows = Array
    //     .from(document.querySelector('tbody').children)
    //     .filter(row => row.children[1].textContent == input.value);
    // rows.forEach(row => row.remove());

    // document.getElementById('result').textContent = rows.length > 0 ? 'Deleted' : 'Not found.';


    // second option 

    // const input = document.getElementsByName('email')[0];
    // let tableInfo = Array.from(document.querySelectorAll('tbody tr td'));
    // let result = document.getElementById('result');

    // for (let index = 1; index < tableInfo.length; index += 2) {
    //     currEmail = tableInfo[index];
    //     if (currEmail.textContent == input.value) {
    //         tableInfo[index - 1].remove();
    //         currEmail.remove();
    //         result.innerHTML = 'Deleted';
    //     }
    // }
    // if (result.innerHTML !== 'Deleted') {
    //     result.innerHTML = 'Not found.';
    // }


    // third option

    // let email = document.getElementsByName("email")[0].value;
    // let secondColumn = document.querySelectorAll(
    //   "#customers tr td:nth-child(2)");
    // for (let td of secondColumn)
    //   if (td.textContent == email) {
    //     let row = td.parentNode;
    //     row.parentNode.removeChild(row);
    //     document.getElementById('result').
    //       textContent = "Deleted.";
    //     return;
    //   }
    // document.getElementById('result').textContent = "Not found.";

    // fourth option

    // const data = {
    //     valueToAdd: document.getElementById("newText").value,
    //     list: document.getElementById("items"),
    // }

    // function eFactory(tag, content) {
    //     const temp = document.createElement(tag)
    //     temp.innerHTML = content

    //     return temp
    // }

    // const item = eFactory("li", data.valueToAdd)
    // const deleteLink = eFactory("a", "[Delete]")
    // deleteLink.href = "#"
    // deleteLink.addEventListener("click", e => e.target.parentNode.remove())

    // item.appendChild(deleteLink)

    // data.list.appendChild(item)
}
