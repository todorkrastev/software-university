export function getUserData() {
    return JSON.parse(sessionStorage.getItem('userData'));
}

export function setUserData(data) {
    sessionStorage.setItem('userData', JSON.stringify(data));
}

export function clearUserData() {
    sessionStorage.removeItem('userData');
}

export function parseQuerystring(string) {
    const params = string
        .split('&')
        .map(p => p.split('='))
        .reduce((a, [k, v]) => Object.assign(a, { [k]: v }), {});

    return params;
}

export function createSubmtiHandler(callback, ...fieldNames) {
    return function(event) {
        event.preventDefault();
        const formData = new FormData(event.target);

        const result = {};

        for (let field of fieldNames) {
            result[field] = formData.get(field).trim();
        }

        callback(result, event);
    };
}