const openButton = document.querySelector(".open-button");
const greetingModal = document.querySelector(".greeting-modal");
const gift = document.querySelector(".gift-section");


openButton.addEventListener("click", () => {
    greetingModal.style.display = "none";
    gift.style.display = "flex";
})

