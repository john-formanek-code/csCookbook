if ("serviceWorker" in navigator) {
    navigator.serviceWorker.register("sw.js");
}

if (!sessionStorage.getItem("chapter")) {
    sessionStorage.setItem("chapter", "Blood Angels");
}

if (!sessionStorage.getItem("weapon")) {
    sessionStorage.setItem("weapon", "Bolter");
}

const chapterSpan = document.getElementById("chapter_span");
const weaponSpan = document.getElementById("weapon_span");
const marineImg = document.getElementById("marine_img");

const chapter = sessionStorage.getItem("chapter");
const weapon = sessionStorage.getItem("weapon");

chapterSpan.innerText = chapter;
weaponSpan.innerText = weapon;

if (chapter === "Blood Angels" && weapon === "Bolter") {
    marineImg.src = "img/ba-bolter.jpg";
}
else if (chapter === "Blood Angels" && weapon === "Melta") {
    marineImg.src = "img/ba-melta.jpg";
}
else if (chapter === "Ultramarines" && weapon === "Bolter") {
    marineImg.src = "img/ultra-bolter.jpg";
}
else if (chapter === "Ultramarines" && weapon === "Melta") {
    marineImg.src = "img/ultra-melta.jpg";
}