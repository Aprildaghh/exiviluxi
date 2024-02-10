const date = document.querySelector(".date");
const timer = document.querySelector(".timer");
const btn = document.querySelector(".presentation-button");

const [year, month, day] = date.innerHTML.split("-");

const countDownDate = new Date(year + ", " + month + ", " + day).getTime();

var x = setInterval(function() {

  var now = new Date().getTime();

  var distance = countDownDate - now;

  var days = Math.floor(distance / (1000 * 60 * 60 * 24));
  var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
  var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
  var seconds = Math.floor((distance % (1000 * 60)) / 1000);

  if (distance < 0) {
    timer.innerHTML = "00:00:00:00";
    clearInterval(x);
    btn.style.visibility = "visible";
    return;
  }

  timer.innerHTML = ((days < 10) ? "0"+days : days)  + ":" + ((hours < 10) ? "0"+hours : hours) + ":"
  + ((minutes < 10) ? "0"+minutes : minutes) + ":" + ((seconds < 10) ? "0"+seconds : seconds);

}, 1000);

