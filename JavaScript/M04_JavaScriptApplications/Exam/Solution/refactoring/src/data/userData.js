export const saveUserData = (data) => sessionStorage.setItem('userData', JSON.stringify(data));

export const getUserData = () => JSON.parse(sessionStorage.getItem('userData'));

export const removeUserData = () => sessionStorage.removeItem('userData');