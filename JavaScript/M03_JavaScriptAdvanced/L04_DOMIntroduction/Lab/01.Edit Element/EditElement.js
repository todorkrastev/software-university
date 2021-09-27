function editElement(element, match, replacer) {
    const matcher = new RegExp(match, 'g');
    element.textContent = element.textContent.replace(matcher, replacer);
    // second option
    // element.textContent = element.textContent.replaceAll(match, replacer);
    // third option
    // element.textContent = element.textContent.split(match).join(replacer);
}