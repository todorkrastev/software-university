function extract(content) {
    const text = document.getElementById(content).textContent;
    let result = '';

    const pattern = /\((.+?)\)/g;

    let match = pattern.exec(text);
    while (match != null) {
        result += match[1];
        result += '; ';

        match = pattern.exec(text);
    }

    return result;

    // second option
    /* const target = document.getElementById(content)

    return target.innerHTML
        .match(/(?!\()[\w*\s*\d*]*(?=\))/g)
        .filter(x => x !== "")
        .join("; ") */
}