//Registrace SW workeru
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

//po nacteni stranky
window.onload = function() {
    //nacteni zbrane a chapter ze sessionStorage
    let weapon = sessionStorage.getItem("weapon");
    let chapter = sessionStorage.getItem("chapter");

    //kontrola ddefault hodnot - pokud nejsou, nastavime defaultni
    if (weapon === null) {
        weapon = "sword";
        sessionStorage.setItem("weapon", weapon);
    }
    if (chapter === null) {
        chapter = "space-wolves";
        sessionStorage.setItem("chapter", chapter);
    }

    //popisky vyberu pro vypis
    let weaponLabel = weapon === "axe" ? "Axe" : "Sword";
    let chapterLabel = chapter === "ultramarines" ? "Ultramarines" : "Space Wolves";

    //podle kombinace vybereme obrazek
    let imageFile =
        chapter === "space-wolves"
            ? (weapon === "axe" ? "SpaceWolfWithAxe.png" : "SpaceWolfWithSword.png")
            : (weapon === "axe" ? "UltramarineWithAxe.png" : "UltramarineWithSword.png");


    //nastaveni textu a obrazku
    document.getElementById("marine_info").innerText =
        "Chapter: " + chapterLabel + " | Zbraň: " + weaponLabel;
    document.getElementById("marine_img").src = "img/" + imageFile;
    document.getElementById("marine_img").alt = chapterLabel + " s " + weaponLabel;
};
