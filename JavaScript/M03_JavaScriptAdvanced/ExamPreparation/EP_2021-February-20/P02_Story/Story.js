// class Story {
//     constructor(title, creator) {
//         this.title = title;
//         this.creator = creator;
//         this._comments = [];
//         this._likes = [];
//     }

//     get likes() {
//         if (this._likes.length === 0) {
//             return `${this.title} has 0 likes`;
//         } else if (this._likes.length === 1) {
//             return `${this._likes[0]} likes this story!`;
//         } else if (1 < this._likes.length) {
//             return `${this._likes[0]} and ${this._likes.length - 1} others like this story!`;
//         }
//     }

//     like(username) {
//         if (this._likes.includes(username)) {
//             throw new Error(`You can't like the same story twice!`);
//         } else if (this.creator === username) {
//             throw new Error(`You can't like your own story!`);
//         } else {
//             this._likes.push(username);
//             return `${username} liked ${this.title}!`;
//         }
//     }

//     dislike(username) {
//         if (this._likes.includes(username)) {
//             this._likes = this._likes.filter(u => u !== username);
//             return `${username} disliked ${this.title}`;
//         } else {
//             throw new Error("You can't dislike this story!");
//         }
//     }

//     comment(username, content, id) {
//         let comment = {
//             Id: id,
//             Username: username,
//             Content: content,
//             Replies: [],
//         };

//         let commentWithId = this._comments.find(c => c.Id === id);

//         if (commentWithId) {
//             let replyID = Number(commentWithId.Id + '.' + (commentWithId.Replies.length + 1));
//             let reply = {
//                 Id: replyID,
//                 Username: username,
//                 Content: content,
//             };

//             commentWithId.Replies.push(reply);

//             return 'You replied successfully';
//         }

//         comment.Id = this._comments.length + 1;
//         this._comments.push(comment);

//         return `${username} commented on ${this.title}`;
//     }


//     toString(sortingType) {
//         let result = [];
//         result.push(`Title: ${this.title}`);
//         result.push(`Creator: ${this.creator}`);
//         result.push(`Likes: ${this._likes.length}`);
//         result.push('Comments:');

//         if (this._comments.length > 0) {
//             let sortedComments = this._sortCriteria(this._comments, sortingType);
//             result.push(this._sortThem(sortedComments, sortingType));
//         }
//         return result.join('\n');
//     }

//     _sortCriteria(commentsOrReplies, criteria) {
//         let copyCommentsOrReplies = commentsOrReplies.slice();
//         let sortedCommentsOrReplies = null;

//         if (criteria === 'asc') {
//             sortedCommentsOrReplies = copyCommentsOrReplies.sort((a, b) => a.Id - b.Id);
//         } else if (criteria === 'desc') {
//             sortedCommentsOrReplies = copyCommentsOrReplies.sort((a, b) => b.Id - a.Id);
//         } else if (criteria === 'username') {
//             sortedCommentsOrReplies = copyCommentsOrReplies.sort((a, b) => a.Username.localeCompare(b.Username));
//         }


//         return sortedCommentsOrReplies;
//     }

//     _sortThem(sortedComments, criteria) {
//         let commentAndReplies = [];

//         for (let comment of sortedComments) {
//             commentAndReplies.push(`-- ${comment.Id}. ${comment.Username}: ${comment.Content}`);

//             if (comment.Replies.length > 0) {
//                 let sortedReplies = this._sortCriteria(comment.Replies, criteria);
//                 sortedReplies.forEach(r => commentAndReplies.push(`--- ${r.Id}. ${r.Username}: ${r.Content}`));
//             }
//         }

//         return commentAndReplies.join('\n');
//     }
// }

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

        let username = this._likes[0];
        if (this._likes.length === 1) {
            return `${username} likes this story!`;
        }

        return `${username} and ${this._likes.length - 1} others like this story!`;
    }

    like(username) {
        if (this._likes.includes(username)) {
            throw new Error(`You can't like the same story twice!`);
        }

        if (username === this.creator) {
            throw new Error(`You can't like your own story!`);
        }

        this._likes.push(username);
        return `${username} liked ${this.title}!`;
    }

    dislike(username) {
        if (!this._likes.includes(username)) {
            throw new Error("You can't dislike this story!");
        }

        this._likes = this._likes.filter(u => u !== username);
        return `${username} disliked ${this.title}`;
    }

    comment(username, content, id) {
        if (id === undefined || !this._comments.some(c => c.Id === id)) {
            let newComment = {
                Id: this._comments.length + 1,
                Username: username,
                Content: content,
                Replies: []
            };

            this._comments.push(newComment);
            return `${username} commented on ${this.title}`;
        }

        let commentToReplyTo = this._comments.find(c => c.Id === id);
        let replyNextId = commentToReplyTo.Replies.length + 1;
        let replyId = Number(`${commentToReplyTo.Id}.${replyNextId}`);
        let reply = {
            Id: replyId,
            Username: username,
            Content: content
        };

        commentToReplyTo.Replies.push(reply);
        return 'You replied successfully';
    }

    toString(sortingType) {
        const sortVersion = {
            asc: (a, b) => a.Id - b.Id,
            desc: (a, b) => b.Id - a.Id,
            username: (a, b) => a.Username.localeCompare(b.Username)
        }

        let comments = this._comments.sort(sortVersion[sortingType]);
        comments.forEach(c => c.Replies.sort(sortVersion[sortingType]));

        let commentsStringArr = [];
        for (const comment of comments) {
            let commentString = `-- ${comment.Id}. ${comment.Username}: ${comment.Content}`;
            let repliesString = comment.Replies
                .map(r => `--- ${r.Id}. ${r.Username}: ${r.Content}`)
                .join('\n');
            repliesString = comment.Replies.length > 0
                ? `\n${repliesString}`
                : '';
            let combinedString = `${commentString}${repliesString}`;
            commentsStringArr.push(combinedString);
        }

        let fullCommentsString = this._comments.length > 0
            ? `\n${commentsStringArr.join('\n')}`
            : '';

        return `Title: ${this.title}
Creator: ${this.creator}
Likes: ${this._likes.length}
Comments:${fullCommentsString}`;
    }
}
