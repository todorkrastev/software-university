import { showSection } from './dom.js';

const homeSection = document.getElementById('homeSection');
homeSection.remove();

const aboutSection = document.getElementById('aboutSection');
aboutSection.remove();

export function showHomePage() {
    showSection(homeSection);
}

export function showAboutPage() {
    showSection(aboutSection);
}