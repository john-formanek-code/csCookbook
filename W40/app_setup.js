// servis worker
if ("serviceWorker" in navigator) {
    window.addEventListener("load", () => {
        navigator.serviceWorker.register("/sw.js")
            .then(registration => {
                console.log("Service Worker registered with scope:", registration.scope);
            })
            .catch(error => {
                console.log("Service Worker registration failed:", error);
            });
    });
}

//nacteni komponent - index.html
const weaponSword = document.getElementById("weapon_sword");
const weaponAxe = document.getElementById("weapon_axe");
const chapterSpaceWolves = document.getElementById("chapter_space_wolves");
const chapterUltramarines = document.getElementById("chapter_ultramarines");
const setupStatus = document.getElementById("setup_status");

//vsem funcke radio buttonum pri zmene
weaponSword.addEventListener("change", ulozNastaveni);
weaponAxe.addEventListener("change", ulozNastaveni);
chapterSpaceWolves.addEventListener("change", ulozNastaveni);
chapterUltramarines.addEventListener("change", ulozNastaveni);

//funkce pro ulozeni nastaveni
function ulozNastaveni() {
    //zjistime zvolenou zbran a chapter
    let weapon = weaponSword.checked ? "sword" : "axe";
    let chapter = chapterSpaceWolves.checked ? "space-wolves" : "ultramarines";

    //ulozime do sessionStorage
    sessionStorage.setItem("weapon", weapon);
    sessionStorage.setItem("chapter", chapter);

    //vypiseme stav
    zobrazStatus(weapon, chapter);
}

//pomocna funkce pro vypis stavu
function zobrazStatus(weapon, chapter) {
    let weaponLabel = weapon === "axe" ? "Axe" : "Sword";
    let chapterLabel = chapter === "ultramarines" ? "Ultramarines" : "Space Wolves";

    setupStatus.innerText = "Aktuální volba: " + chapterLabel + " + " + weaponLabel;
}

//po nacteni stranky
window.onload = function() {
    //nacteni hodnot ze sessionStorage
    let weapon = sessionStorage.getItem("weapon");
    let chapter = sessionStorage.getItem("chapter");

    //kontrola defaultu
    if (weapon === null) {
        weapon = "sword";
        sessionStorage.setItem("weapon", weapon);
    }
    if (chapter === null) {
        chapter = "space-wolves";
        sessionStorage.setItem("chapter", chapter);
    }

    //nastaveni radio-buttonu
    weaponSword.checked = weapon === "sword" ? true : false;
    weaponAxe.checked = weapon === "axe" ? true : false;
    chapterSpaceWolves.checked = chapter === "space-wolves" ? true : false;
    chapterUltramarines.checked = chapter === "ultramarines" ? true : false;

    //vypis stavu
    zobrazStatus(weapon, chapter);
};
