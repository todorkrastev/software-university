(function () {
    String.prototype.ensureStart = function (str) {
        if (this.startsWith(str)) {
            return this.toString();
        }

        return `${str}${this}`;
    };

    String.prototype.ensureEnd = function (str) {
        if (this.endsWith(str)) {
            return this.toString();
        }

        return `${this}${str}`;
    };


    String.prototype.isEmpty = function () {
        return this.toString() === '';
    };

    String.prototype.truncate = function (n) {
        if (this.length <= n) {
            return this.toString();
        }

        if (this.includes(' ')) {
            let words = this.split(' ');
            while (words.join(' ').length + 3 > n) {
                words.pop();
            }
            let sentence = `${words.join(' ')}...`;
            return sentence;
        }

        if (n > 3) {
            let string = `${this.slice(0, n - 3)}...`;
            return string;
        }

        return '.'.repeat(n);
    };

    String.format = function (string, ...params) {
        let replaceRegex = /{(\d+)}/g;
        let replacedString = string.replace(replaceRegex, (match, group1) => {
            let index = Number(group1);
            if (index < params.length) {
                return params[index];
            }

            return match;
        });

        return replacedString;
    };
}())
