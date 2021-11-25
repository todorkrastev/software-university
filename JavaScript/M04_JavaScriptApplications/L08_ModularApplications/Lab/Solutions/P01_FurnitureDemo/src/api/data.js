import * as api from './api.js';

export const login = api.login;
export const register = api.register;
export const logout = api.logout;

const pageSize = 4;

const endpoints = {
    all: '/data/catalog?pageSize=4&offset=',
    count: '/data/catalog?count',
    byId: '/data/catalog/',
    myItems: (userId) => `/data/catalog?where=_ownerId%3D%22${userId}%22`,
    countMyItems: (userId) => `/data/catalog?where=_ownerId%3D%22${userId}%22&count`,
    create: '/data/catalog',
    edit: '/data/catalog/',
    delete: '/data/catalog/'
}

export async function getAll(page, search) {
    let url1 = endpoints.all + (page - 1) * pageSize;
    let url2 = endpoints.count;

    if (search) {
        url1 += '&where=' + encodeURIComponent(`make LIKE "${search}"`);
        url2 += '&where=' + encodeURIComponent(`make LIKE "${search}"`);
    }

    const [data, count] = await Promise.all([
        api.get(url1),
        api.get(url2)
    ]);
    return {
        data,
        pages: Math.ceil(count / pageSize)
    };
}

export async function getById(id) {
    return api.get(endpoints.byId + id);
}

export async function getMyItems(userId) {
    const [data, count] = await Promise.all([
        api.get(endpoints.myItems(userId)),
        api.get(endpoints.countMyItems(userId))
    ]);
    return {
        data,
        pages: Math.ceil(count / pageSize)
    };
}

export async function createItem(data) {
    return api.post(endpoints.create, data);
}

export async function editItem(id, data) {
    return api.put(endpoints.edit + id, data);
}

export async function deleteItem(id) {
    return api.del(endpoints.delete + id);
}

