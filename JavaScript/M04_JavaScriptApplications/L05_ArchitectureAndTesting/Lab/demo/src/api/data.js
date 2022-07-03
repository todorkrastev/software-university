import * as api from './api.js';

export const login = api.login;
export const register = api.register;
export const logout = api.logout;


const endpoints = {
  movies: '/data/movies'
}

export async function getAllMovies(){
  return api.get(endpoints.movies);
}