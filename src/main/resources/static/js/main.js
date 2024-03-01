// wait for the content to load
window.addEventListener("DOMContentLoaded", () => {

    // help button modal popup
    const helpBtn = document.querySelector(".help-button");
    const informative = document.querySelector(".informative");

    helpBtn.addEventListener("click", () => {
        informative.style.display = "block";
        informative.style.animation = "modalOpen ease 0.5s";
    })

    informative.addEventListener("click", () => {
        informative.style.animation = "informativeSlideDown ease 0.5s";
        setTimeout(() => {
            informative.style.display = "none";
        }, 480);
    })

})


