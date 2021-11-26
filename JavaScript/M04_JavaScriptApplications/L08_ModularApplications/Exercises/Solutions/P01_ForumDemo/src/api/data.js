import * as api from './api.js';


export const login = api.login;
export const regster = api.register;
export const logout = api.logout;


const endpoints = {
    topics: `/data/topics?load=${encodeURIComponent('author=_ownerId:users,comments=_id:')}&select=_id,title,_ownerId`,
    topicCount: '/data/topics?count',
    topicById: (id) => `/data/topics/${id}?load=${encodeURIComponent('author=_ownerId:users')}`,
    createTopic: '/data/topics',
    commentsByTopicId: (topicId) => '/data/topicComments?where=' + encodeURIComponent(`topicId="${topicId}"`) + `&sortBy=_createdOn%20desc&load=${encodeURIComponent('author=_ownerId:users,comments=_id:')}`,
    createComment: '/data/topicComments'
};

export async function getAllTopics() {
    return api.get(endpoints.topics);
}

export async function getTopicCount() {
    return api.get(endpoints.topicCount);
}

export async function getTopicById(id) {
    return api.get(endpoints.topicById(id));
}

export async function createTopic(topic) {
    return api.post(endpoints.createTopic, topic);
}

export async function getCommentsByTopicId(topicId) {
    return api.get(endpoints.commentsByTopicId(topicId));
}

export async function createComment(comment) {
    return api.post(endpoints.createComment, comment);
}