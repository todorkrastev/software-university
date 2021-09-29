function addItem() {
    let input = document.getElementById('newItemText');
    let li = document.createElement('li');
    li.appendChild(document.createTextNode(input.value)); // -> li.textContent = input.value;
    document.getElementById('items').appendChild(li);
    input.value = '';

    // second option
    
    // const data = {
    //     valueToAdd: document.getElementById("newItemText").value,
    //     list: document.getElementById("items"),
    // }

    // function eFactory(tag, content) {
    //     const temp = document.createElement(tag)
    //     temp.innerHTML = content
    //     return temp
    // }

    // data.list.appendChild(eFactory("li", data.valueToAdd))
}
