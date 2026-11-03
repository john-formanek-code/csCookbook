// Registrace Service Workeru pro offline aplikaci
if("serviceWorker" in navigator) {
    navigator.serviceWorker.register("./sw.js");
}

function updateView() {
    const weapon = document.getElementById("weaponSelect").value;
    const skinCheck = document.getElementById("skinCheck");
    const wrapCheck = document.getElementById("wrapCheck");

    // Kdyz neni vybrana zbran, skin a wrap nedavaji smysl
    if(weapon === "Empty") {
        skinCheck.checked = false;
        wrapCheck.checked = false;
        skinCheck.disabled = true;
        wrapCheck.disabled = true;
    } else {
        skinCheck.disabled = false;
        wrapCheck.disabled = false;
    }

    const skin = skinCheck.checked;
    const wrap = wrapCheck.checked;
    let obrazek = weapon;

    if(skin && wrap) {
        obrazek += "+Skin+Wrap";
    } else if(skin) {
        obrazek += "+Skin";
    } else if(wrap) {
        obrazek += "+Wrap";
    }

    document.getElementById("weaponImg").src = "img/" + obrazek + ".png";
    document.getElementById("weaponImg").alt = obrazek;
}

async function saveFavorite() {
    const weapon = document.getElementById("weaponSelect").value;
    const skin = document.getElementById("skinCheck").checked;
    const wrap = document.getElementById("wrapCheck").checked;

    try {
        await addFavorite(weapon, skin, wrap);
        alert("Zbraň byla uložena do oblíbených");
    } catch(error) {
        alert("Chyba při ukládání zbraně");
    }
}

window.onload = async function() {
    try {
        await initDB();
    } catch(error) {
        alert("Nepodařilo se otevřít databázi");
    }

    // Zobrazeni zbrane po kliknuti v oblibenych
    const params = new URLSearchParams(window.location.search);
    const weapon = params.get("weapon");

    if(weapon === "Empty" || weapon === "BR" || weapon === "RPG") {
        document.getElementById("weaponSelect").value = weapon;
        document.getElementById("skinCheck").checked = params.get("skin") === "true";
        document.getElementById("wrapCheck").checked = params.get("wrap") === "true";
    }

    updateView();
};
