import * as api from './api.js';
import { addOwner, createPointer, endpoints } from './data.js';


export function getCommentsByRecipeId(recipeId) {
    return api.get(endpoints.commentsByRecipe(recipeId));
}

export function createComment(recipeId, comment) {
    comment.recipe = createPointer('Recipe', recipeId);
    addOwner(comment);
    return api.post(endpoints.comments, comment);
}