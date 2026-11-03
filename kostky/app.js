//registrace service workeru
if ("serviceWorker" in navigator) {
    window.addEventListener("load", () => {
        navigator.serviceWorker.register("./sw.js");
    });
}

//promenne pro hru
let cil = 0;
let hrac_soucet = 0;
let pocitac_soucet = 0;
let kostka = 0;
let vysledek = "";
let hotovo = false;

//nahodne cislo od min do max
function nahodneCislo(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
}

//po nacteni stranky
window.onload = async function() {
    try {
        await initDB();
    } catch (error) {
        console.log("Chyba databaze:", error);
    }

    //nacteme rozehranou hru ze sessionStorage
    cil = parseInt(sessionStorage.getItem("cil"));
    hrac_soucet = parseInt(sessionStorage.getItem("hrac_soucet"));
    pocitac_soucet = parseInt(sessionStorage.getItem("pocitac_soucet"));
    kostka = parseInt(sessionStorage.getItem("kostka"));
    vysledek = sessionStorage.getItem("vysledek") || "";
    hotovo = sessionStorage.getItem("hotovo") === "true";

    if (isNaN(cil)) {
        novaHra();
    } else {
        if (isNaN(hrac_soucet)) hrac_soucet = 0;
        if (isNaN(pocitac_soucet)) pocitac_soucet = 0;
        if (isNaN(kostka)) kostka = 0;
        zobraz();
    }
}

//ulozeni aktualni hry
function ulozHru() {
    sessionStorage.setItem("cil", cil);
    sessionStorage.setItem("hrac_soucet", hrac_soucet);
    sessionStorage.setItem("pocitac_soucet", pocitac_soucet);
    sessionStorage.setItem("kostka", kostka);
    sessionStorage.setItem("vysledek", vysledek);
    sessionStorage.setItem("hotovo", hotovo);
}

//aktualizace stranky
function zobraz() {
    document.getElementById("cil_label").innerText = cil;
    document.getElementById("hrac_label").innerText = hrac_soucet;
    document.getElementById("kostka_label").innerText = kostka === 0 ? "" : kostka;
    document.getElementById("pocitac_label").innerText = hotovo ? pocitac_soucet : "";
    document.getElementById("vysledek_label").innerText = vysledek;
    document.getElementById("hazet_btn").disabled = hotovo;
    document.getElementById("konec_btn").disabled = hotovo;
    document.getElementById("nova_hra_btn").hidden = !hotovo;
}

//zacatek nove hry
function novaHra() {
    cil = nahodneCislo(10, 20);
    hrac_soucet = 0;
    pocitac_soucet = 0;
    kostka = 0;
    vysledek = "";
    hotovo = false;
    ulozHru();
    zobraz();
}

//hrac hodi jednou kostkou
function hazet() {
    if (hotovo) return;

    kostka = nahodneCislo(1, 6);
    hrac_soucet += kostka;
    ulozHru();
    zobraz();

    //kdyz hrac presahne cil, dal uz hazet nema smysl
    if (hrac_soucet >= cil) {
        konec();
    }
}

//ukonceni tahu hrace - pak hraje pocitac
async function konec() {
    if (hotovo) return;
    hotovo = true;

    //pocitac hazi s pravdepodobnosti 85 %, jinak skonci
    while (pocitac_soucet < cil) {
        if (pocitac_soucet > 0 && nahodneCislo(1, 100) > 85) {
            break;
        }
        pocitac_soucet += nahodneCislo(1, 6);
    }

    //vyhodnoceni
    if (hrac_soucet > cil && pocitac_soucet > cil) {
        vysledek = "REMÍZA";
    } else if (hrac_soucet > cil) {
        vysledek = "PROHRA";
    } else if (pocitac_soucet > cil) {
        vysledek = "VÝHRA";
    } else if (hrac_soucet > pocitac_soucet) {
        vysledek = "VÝHRA";
    } else if (hrac_soucet < pocitac_soucet) {
        vysledek = "PROHRA";
    } else {
        vysledek = "REMÍZA";
    }

    //ulozime ukoncenou hru, aby refresh nepridal dalsi vysledek
    ulozHru();
    zobraz();

    //zapocitame skore (remiza ho nemeni)
    let hrac_score = parseInt(localStorage.getItem("hrac_score")) || 0;
    let pocitac_score = parseInt(localStorage.getItem("pocitac_score")) || 0;

    if (vysledek === "VÝHRA") {
        hrac_score++;
    } else if (vysledek === "PROHRA") {
        pocitac_score++;
    }
    localStorage.setItem("hrac_score", hrac_score);
    localStorage.setItem("pocitac_score", pocitac_score);

    //zaznam do IndexedDB
    try {
        if (db === null) await initDB();
        await addGame(cil, hrac_soucet, pocitac_soucet, vysledek);
    } catch (error) {
        console.log("Nepodarilo se ulozit hru:", error);
    }
}
