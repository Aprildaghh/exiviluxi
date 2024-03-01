// color label background color change on slide
const red = document.querySelector(".red-choice");
const green = document.querySelector(".green-choice");
const blue = document.querySelector(".blue-choice");
const colorLabel = document.querySelector(".color-label");
const colorInput = document.getElementById("color-input");

setInterval(() => {
    const newColor = `rgb(${red.value}, ${green.value}, ${blue.value})`
    colorLabel.style.backgroundColor = newColor;
    colorInput.value = newColor;
}, 40);

// show up showcase modal and set up the gift section
const showcaseModal = document.querySelector(".showcase-modal");
const showcaseBtn = document.querySelector(".showcase");
const hideDiv = document.querySelector(".hide");
const giftSection = document.querySelector(".gift-section");
const giftVideo = document.querySelector(".gift-video");
const imageUrl = document.querySelector(".image-url");
const videoUrl = document.querySelector(".youtube-url");

showcaseBtn.addEventListener("click", () => {
    $(".showcase-modal").fadeIn();
    showcaseModal.style.display = "flex";
    hideDiv.style.display = "block";
    
    if(imageUrl.value === "")
    {
        giftSection.style.backgroundColor = `rgb(${red.value}, ${green.value}, ${blue.value})`;
    }
    else
    {
        giftSection.style.background = `url('${imageUrl.value}')`;
    }

    // process video url
    let videoId = videoUrl.value.split("=")[1];
    console.log(videoId);
    giftVideo.src = `https://www.youtube.com/embed/${videoId}`;
})

hideDiv.addEventListener("click", () => {
    hideDiv.style.display = "none";
    $(".showcase-modal").fadeOut();
})
