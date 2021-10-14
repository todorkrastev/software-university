function solve() {
    class Post {
        constructor(title, content) {
            this.title = title;
            this.content = content;
        }

        toString() {
            return `Post: ${this.title}\nContent: ${this.content}`;
        }
    }

    class SocialMediaPost extends Post {
        constructor(title, content, likes, dislikes) {
            super(title, content);
            this.likes = likes;
            this.dislikes = dislikes;
            this.comments = [];
        }

        addComment(comment) {
            this.comments.push(comment);
        }

        toString() {
            let baseToString = super.toString();
            let commentsString = this.comments.map(c => ` * ${c}`).join('\n');
            let fullCommentsString = this.comments.length > 0 ?
                `\nComments:\n${commentsString}` :
                '';

            return `${baseToString}\nRating: ${this.likes - this.dislikes}${fullCommentsString}`;
        }
    }

    class BlogPost extends Post {
        constructor(title, content, views) {
            super(title, content);
            this.views = views;
        }

        view() {
            this.views = this.views + 1;
            return this;
        }

        toString() {
            let baseToString = super.toString();
            return `${baseToString}\nViews: ${this.views}`;
        }
    }

    return {
        Post,
        SocialMediaPost,
        BlogPost
    }
}
