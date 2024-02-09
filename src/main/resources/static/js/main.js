// sign up button modal popup
const signupBtn = document.querySelector(".signup");
const signupModal = document.querySelector(".signupModal");
const signupTosigninBtn = document.querySelector(".signup-to-signin");

signupBtn.addEventListener("click", () => {openModal(signupModal)});

signupModal.addEventListener("click", () => {closeSignModal(signupModal)});

signupTosigninBtn.addEventListener("click", () => {
    closeSignModal(signupModal);
    openModal(signinModal);
})

// sign in button modal popup
const signinBtn = document.querySelector(".signin");
const signinModal = document.querySelector(".signinModal");
const signinTosignupBtn = document.querySelector(".signin-to-signup");

signinBtn.addEventListener("click", () => {openModal(signinModal)})

signinModal.addEventListener("click", () => {closeSignModal(signinModal)})

signinTosignupBtn.addEventListener("click", () => {
    closeSignModal(signinModal);
    openModal(signupModal);
})

// help button modal popup
const helpBtn = document.querySelector(".help-button");
const informative = document.querySelector(".informative");

helpBtn.addEventListener("click", () => {openModal(informative)})

informative.addEventListener("click", () => {
    informative.style.animation = "informativeSlideDown ease 0.5s";
    setTimeout(() => {
        informative.style.display = "none";
    }, 480);
})

function closeSignModal(modal) {
    modal.style.animation = "signSlideDown ease 0.5s";
    setTimeout(() => {
        modal.style.display = "none";
    }, 480);
    
}

function openModal(modal) {
    modal.style.display = "block";
    modal.style.animation = "modalOpen ease 0.5s";
}