if (!sessionStorage.getItem("chapter")) {
    sessionStorage.setItem("chapter", "Blood Angels");
}

if (!sessionStorage.getItem("weapon")) {
    sessionStorage.setItem("weapon", "Bolter");
}

const chapterRadios = document.querySelectorAll('input[name="chapter"]');
const weaponRadios = document.querySelectorAll('input[name="weapon"]');

const currentChapter = sessionStorage.getItem("chapter");
const currentWeapon = sessionStorage.getItem("weapon");

chapterRadios.forEach((radio) => {
    if (radio.value === currentChapter) {
        radio.checked = true;
    }

    radio.addEventListener("change", () => {
        sessionStorage.setItem("chapter", radio.value);
    });
});

weaponRadios.forEach((radio) => {
    if (radio.value === currentWeapon) {
        radio.checked = true;
    }

    radio.addEventListener("change", () => {
        sessionStorage.setItem("weapon", radio.value);
    });
});