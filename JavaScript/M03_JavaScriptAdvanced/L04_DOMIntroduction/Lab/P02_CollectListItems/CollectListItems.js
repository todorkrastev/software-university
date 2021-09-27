function extractText() {
    const items = document.getElementById('items').children;
    // second option
    // const items = document.querySelectorAll('#items li');

    const result = [];

    for (const item of Array.from(items)) {
        result.push(item.textContent);
    }
    document.getElementById('result').textContent = result.join('\n');

    // third option
    /* const html = {
        list: () => document.getElementById("items"),
        result: () => document.getElementById("result"),
    }

    html.result().innerHTML = Array.from(html.list().children)
        .map(x => x.innerHTML)
        .join("\n") */
}