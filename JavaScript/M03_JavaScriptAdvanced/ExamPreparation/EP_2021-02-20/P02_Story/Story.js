class Story {
    constructor(title, creator) {
        this.title = title;
        this.creator = creator;
        this._comments = [];
        this._likes = [];
    }

    get likes() {

        if (this._likes.length === 0) {
            return `${this.title} has 0 likes`;
        }

        if (this._likes.length === 1) {
            return `${this._likes[0]} likes this story!`;
        }

        return `${this._likes[0]} and ${this._likes.length - 1} others like this story!`;
    }

    like(username) {

        if (this._likes.includes(username)) {
            throw new Error(`You can't like the same story twice!`);
        }

        if (this.creator === username) {
            throw new Error(`You can't like your own story!`);
        }

        this._likes.push(username);

        return `${username} liked ${this.title}!`;
    }

    dislike(username) {

        if (this._likes.includes(username) === false) {
            throw new Error(`You can't dislike this story!`);
        }

        let index = this._likes.indexOf(username);
        this._likes.splice(index, 1);

        return `${username} disliked ${this.title}`;

    }

    comment(username, content, id) {

        if (id === undefined || this._comments.some(c => c.id === id) === false) {
            this._comments.push({
                id: this._comments.length + 1,
                username,
                content,
                replies: []
            });

            return `${username} commented on ${this.title}`;
        }

        let comment = this._comments.find(c => c.id === id);
        comment.replies.push({
            id: `${comment.id}.${comment.replies.length + 1}`,
            username,
            content
        });

        return `You replied successfully`;
    }

    toString(sortingType) {
        let output = [];

        output.push(`Title: ${this.title}`);
        output.push(`Creator: ${this.creator}`);
        output.push(`Likes: ${this._likes.length}`);
        output.push('Comments:');

        const sorting = {
            asc: (a, b) => a.id - b.id,
            desc: (a, b) => b.id - a.id,
            username: (a, b) => a.username.localeCompare(b.username)
        };

        let sortedComments = this._comments.sort(sorting[sortingType]);
        sortedComments.forEach(c => c.replies.sort(sorting[sortingType]));


        sortedComments.forEach(c => {
            output.push(`-- ${c.id}. ${c.username}: ${c.content}`);
            c.replies.forEach(r => {
                output.push(`--- ${r.id}. ${r.username}: ${r.content}`);
            })
        });

        return output.join('\n');
    }
}



// second option

/*
class Story {
    constructor(title, creator) {
        this.title = title;
        this.creator = creator;
        this._comments = [];
        this._likes = [];
    }

    get likes() {
        if (this._likes.length === 0) {
            return `${this.title} has 0 likes`;
        } else if (this._likes.length === 1) {
            return `${this._likes[0]} likes this story!`;
        }
        return `${this._likes[0]} and ${this._likes.length - 1} others like this story!`;

    }

    like(username) {
        if (this._likes.includes(username)) {
            throw new Error('You can\'t like the same story twice!');
        } else if (this.creator === username) {
            throw new Error('You can\'t like your own story!');
        }

        this._likes.push(username);

        return `${username} liked ${this.title}!`;
    }

    dislike(username) {
        if (this._likes.includes(username) === false) {
            throw new Error(`You can't dislike this story!`);
        }

        let index = this._likes.indexOf(username);
        this._likes.splice(index, 1);
        return `${username} disliked ${this.title}`;
    }

    comment(username, content, id) {
        if (id === undefined || this._comments.some(x => x.id === id) === false) {
            let comment = {
                id: this._comments.length + 1,
                username,
                content,
                replies: [],
            };
            this._comments.push(comment);

            return `${username} commented on ${this.title}`;
        }

        let comment = this._comments.find(x => x.id === id);
        let reply = {
            id: comment.replies.length + 1,
            username,
            content,
        };

        comment.replies.push(reply);

        return `You replied successfully`;
    }

    toString(sortingType) {
        let output = '';
        output += `Title: ${this.title}\n`;
        output += `Creator: ${this.creator}\n`;
        output += `Likes: ${this._likes.length}\n`;
        output += 'Comments:';

        if (this._comments.length > 0) {
            if (sortingType === 'asc') {
                for (const comment of this._comments.sort((a, b) => a.id - b.id)) {
                    output += `\n-- ${comment.id}. ${comment.username}: ${comment.content}`;
                    for (const reply of comment.replies.sort((a, b) => a.id - b.id)) {
                        output += `\n--- ${comment.id}.${reply.id}. ${reply.username}: ${reply.content}`;
                    }
                }
            } else if (sortingType === 'desc') {
                for (const comment of this._comments.sort((a, b) => b.id - a.id)) {
                    output += `\n-- ${comment.id}. ${comment.username}: ${comment.content}`;
                    for (const reply of comment.replies.sort((a, b) => b.id - a.id)) {
                        output += `\n--- ${comment.id}.${reply.id}. ${reply.username}: ${reply.content}`;
                    }
                }
            } else if (sortingType === 'username') {
                for (const comment of this._comments.sort((a, b) => a.username.localeCompare(b.username))) {
                    output += `\n-- ${comment.id}. ${comment.username}: ${comment.content}`;
                    for (const reply of comment.replies.sort((a, b) => a.username.localeCompare(b.username))) {
                        output += `\n--- ${comment.id}.${reply.id}. ${reply.username}: ${reply.content}`;
                    }
                }
            }
        }
        return output;
    }
}
 */