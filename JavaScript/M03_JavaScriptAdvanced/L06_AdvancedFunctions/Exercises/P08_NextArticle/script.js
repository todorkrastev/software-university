function getArticleGenerator(articles) {
    let contentDiv = document.querySelector('#content');

    function closure() {
        let articleTag = document.createElement('article');
        if (articles.length <= 0) return
        articleTag.textContent = articles.shift()
        contentDiv.appendChild(articleTag);
    }
    return closure;



    // second option


    // const output = document.getElementById("content");
    // const ourCopy = articles.slice();

    // return function showNext(arr = []) {
    //     if (ourCopy[0] !== undefined) {
    //         const article = document.createElement("article");
    //         article.innerHTML = ourCopy.shift();
    //         output.appendChild(article);
    //     }

    //     return showNext;
    // }
}
