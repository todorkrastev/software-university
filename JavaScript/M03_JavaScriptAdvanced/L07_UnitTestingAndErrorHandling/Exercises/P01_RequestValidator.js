function solve(httpObj) {
    validateMethod(httpObj);
    validateUri(httpObj);
    validateVersion(httpObj);
    validateMessage(httpObj);

    function validateMessage(httpObj) {
        let propName = 'message';
        let messageRegEx = /^[^<>\\&'"]*$/;

        if (httpObj[propName] === undefined || !messageRegEx.test(httpObj[propName])) {
            throw new Error(`Invalid request header: Invalid Message`);
        }
    }

    function validateVersion(httpObj) {
        let propName = 'version';
        let validVersion = ['HTTP/0.9', 'HTTP/1.0', 'HTTP/1.1', 'HTTP/2.0'];

        if (httpObj[propName] === undefined || !validVersion.includes(httpObj[propName])) {
            throw new Error(`Invalid request header: Invalid Version`);
        }

    }

    function validateUri(httpObj) {
        let propName = 'uri';
        let uriRegex = /^\*$|^[a-zA-Z0-9.]+$/;

        if (httpObj[propName] === undefined || !uriRegex.test(httpObj[propName])) {
            throw new Error(`Invalid request header: Invalid URI`);
        }
    }

    function validateMethod(httpObj) {
        let propName = 'method';
        let validMethods = ['GET', 'POST', 'DELETE', 'CONNECT'];

        if (httpObj[propName] === undefined || !validMethods.includes(httpObj[propName])) {
            throw new Error('Invalid request header: Invalid Method');
        }
    }

    return httpObj;
}
