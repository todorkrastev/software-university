async function requester(URL, options) {
    let response;
    try {
        response = await fetch(URL, options);

        if (response.status == 200) {
            return await response.json();
        } else {
            const error = await response.json();
            throw new Error(error.message);
        }

    } catch (error) {

        if (error instanceof SyntaxError) {
            return response;
        } else if (error.message == 'Invalid access token') {
            console.log('Invalid session, resetting storage');
            sessionStorage.clear();
            window.location.pathname = '/';
        } else {
            throw error;
        }

    }
}

function getOptions(type, body, token) {
    const options = {
        post: {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(body)
        },
        get: {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        },
        put: {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(body)
        },
        delete: {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json'
            }
        }
    };
    const option = options[type];
    token ? option.headers['X-Authorization'] = token : '';
    return option;
}

export const registerUser = async (body) => await requester('http://localhost:3030/users/register', getOptions('post', body));

export const loginUser = async (body) => await requester('http://localhost:3030/users/login', getOptions('post', body));

export const logoutUser = async (token) => await requester('http://localhost:3030/users/logout', getOptions('get', {}, token));

export const getArticles = async () => await requester('http://localhost:3030/data/albums?sortBy=_createdOn%20desc&distinct=name');

export const getArticlesByCategory = async () => await requester('http://localhost:3030/data/wiki?sortBy=_createdOn%20desc&distinct=category');

export const getArticlesBySearchTitle = async (query) => await requester(`http://localhost:3030/data/albums?where=name%20LIKE%20%22${query}%22`);

export const getArticleById = async (id) => await requester('http://localhost:3030/data/albums/' + id);

export const createArticle = async (body, token) => await requester('http://localhost:3030/data/albums', getOptions('post', body, token));

export const editArticle = async (id, body, token) => await requester('http://localhost:3030/data/albums/' + id, getOptions('put', body, token));

export const deleteArticle = async (id, token) => await requester('http://localhost:3030/data/albums/' + id, getOptions('delete', {}, token));