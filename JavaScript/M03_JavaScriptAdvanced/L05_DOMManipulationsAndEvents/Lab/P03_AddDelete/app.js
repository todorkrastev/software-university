function addItem() {
    const input = document.getElementById('newItemText');

    if (input.value.length === 0) {
        return;
    }

    const liElement = document.createElement('li');
    liElement.textContent = input.value;

    const button = document.createElement('a');
    button.href = '#';
    button.textContent = '[Delete]';
    button.addEventListener('click', removeElement);

    liElement.appendChild(button);

    document.getElementById('items').appendChild(liElement);

    input.value = '';

    function removeElement(ev) {
        //  let result = confirm('Are you sure you want to delete this record?');
        //   if (result) {
        const parent = ev.target.parentNode;
        parent.remove();
        //   }
    }

    // using DOM Event Delegation

    // document.getElementById('items').addEventListener('click', removeElement);

    // function removeElement(ev) {
    //     if (ev.target.tagName == 'A') {
    //         const parent = ev.target.parentNode;
    //         parent.remove();
    //     }
    // }

    // function addItem() {
    //     const input = document.getElementById('newItemText');

    //     const liElement = document.createElement('li');
    //     liElement.textContent = input.value;

    //     const button = document.createElement('a');
    //     button.href = '#';
    //     button.textContent = '[Delete]';

    //     liElement.appendChild(button);

    //     document.getElementById('items').appendChild(liElement);


    //     input.value = '';
    // }

    // second option

    // let input = document.getElementById('newItemText');
    // if (input.value.length === 0) {
    //     return;
    // }
    // let li = document.createElement('li');
    // li.appendChild(document.createTextNode(input.value)); // -> li.textContent = input.value;
    // let listItems = document.getElementById('items');
    // let remove = document.createElement('a');
    // let linkText = document.createTextNode("[Delete]");
    // remove.appendChild(linkText);
    // remove.href = '#';
    // remove.addEventListener("click", deleteItem);

    // li.appendChild(remove);
    // listItems.appendChild(li);

    // function deleteItem() {
    //     li.remove();
    // }

    // input.value = '';

    // third option 

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
