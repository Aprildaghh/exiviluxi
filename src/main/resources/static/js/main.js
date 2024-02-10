// wait for the content to load
window.addEventListener("DOMContentLoaded", () => {

    // sign up button modal popup
    const signupBtn = document.querySelector(".signup");
    const signupModal = document.querySelector(".signupModal");
    const signupTosigninBtn = document.querySelector(".signup-to-signin");

    if(signupBtn)
        signupBtn.addEventListener("click", () => {openModal(signupModal)});

    signupModal.addEventListener("click", (e) => {closeSignModalWithEl(e, signupModal)});

    signupTosigninBtn.addEventListener("click", (e) => {
        e.preventDefault();
        closeSignModal(signupModal);
        openModal(signinModal);
    })

    // sign in button modal popup
    const signinBtn = document.querySelector(".signin");
    const signinModal = document.querySelector(".signinModal");
    const signinTosignupBtn = document.querySelector(".signin-to-signup");

    if(signinBtn)
        signinBtn.addEventListener("click", () => {openModal(signinModal)})

    signinModal.addEventListener("click", (e) => {closeSignModalWithEl(e, signinModal)})

    signinTosignupBtn.addEventListener("click", (e) => {
        e.preventDefault();
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

    // presentation button sign in modal popup
    const presentation_show_signin = document.querySelector(".presentation-show-signin");

    if(presentation_show_signin)
        presentation_show_signin.addEventListener("click", () => {openModal(signinModal)});

    function closeSignModal(modal)
    {
        modal.style.animation = "signSlideDown ease 0.5s";
                setTimeout(() => {
                    modal.style.display = "none";
                }, 480);
    }

    function closeSignModalWithEl(el, modal) {

        if(el.target != modal) return;

        modal.style.animation = "signSlideDown ease 0.5s";
        setTimeout(() => {
            modal.style.display = "none";
        }, 480);

    }

    function openModal(modal) {
        modal.style.display = "block";
        modal.style.animation = "modalOpen ease 0.5s";
    }

})


