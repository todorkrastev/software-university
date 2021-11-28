class ArtGallery {
    constructor(creator) {
        this.creator = creator;
        this.possibleArticles = {
            picture: 200,
            photo: 50,
            item: 250
        };
        this.listOfArticles = [];
        this.guests = [];
    }

    addArticle(articleModel, articleName, quantity) {
        articleModel = articleModel.toLowerCase();

        if (this.possibleArticles.hasOwnProperty(articleModel) == false) {
            throw new Error('This article model is not included in this gallery!');
        }

        let article = this.listOfArticles.some(a => a.articleName === articleName && a.articleModel === articleModel);
        if (article === true) {
            this.listOfArticles
                .find(a => a.articleName === articleName && a.articleModel === articleModel)
                .quantity += quantity;
        } else if (article === false) {
            this.listOfArticles.push({
                articleModel,
                articleName,
                quantity
            });
        }

        return `Successfully added article ${articleName} with a new quantity- ${quantity}.`;
    }

    inviteGuest(guestName, personality) {
        if (this.guests.some(g => g.guestName === guestName) === true) {
            throw new Error(`${guestName} has already been invited.`);
        }

        let points;
        if (personality === 'Vip') {
            points = 500;
        } else if (personality === 'Middle') {
            points = 250
        } else {
            points = 50;
        }

        this.guests.push({
            guestName,
            points: points,
            purchaseArticle: 0
        });

        return `You have successfully invited ${guestName}!`;
    }

    buyArticle(articleModel, articleName, guestName) {
        if (this.listOfArticles.some(a => a.articleName === articleName && a.articleModel === articleModel) === false) {
            throw new Error('This article is not found.');
        }

        let article = this.listOfArticles.find(a => a.articleModel === articleModel && a.articleName === articleName);
        if (article.quantity <= 0) {
            return `The ${articleName} is not available.`;
        }

        if (this.guests.some(g => g.guestName === guestName) === false) {
            return `This guest is not invited.`;
        }

        let guest = this.guests.find(g => g.guestName === guestName);
        let articlePoints = this.possibleArticles[articleModel];

        if (guest.points < articlePoints) {
            return `You need to more points to purchase the article.`;
        }

        guest.points -= articlePoints;
        article.quantity -= 1;
        guest.purchaseArticle += 1;

        return `${guestName} successfully purchased the article worth ${articlePoints} points.`;
    }

    showGalleryInfo(criteria) {
        let output = [];

        if (criteria === 'article') {
            output.push('Articles information:');
            this.listOfArticles.forEach(a => output.push(`${a.articleModel} - ${a.articleName} - ${a.quantity}`));
        } else if (criteria === 'guest') {
            output.push('Guests information:');
            this.guests.forEach(g => output.push(`${g.guestName} - ${g.purchaseArticle}`));
        }

        return output.join('\n');
    }
}
