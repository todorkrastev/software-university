const homeSection = document.getElementById('homeSection');
homeSection.remove();

const aboutSection = document.getElementById('aboutSection');
aboutSection.remove();

export function showHomePage(ctx){
  ctx.showSection(homeSection);
}

export function showAboutPage(ctx){
  ctx.showSection(aboutSection);
}