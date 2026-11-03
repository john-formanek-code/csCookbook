// registrace sw
if ("serviceWorker" in navigator) {
    window.addEventListener("load", () => {
        navigator.serviceWorker.register("./sw.js")
            .then(registration => {
                console.log("Service Worker registered with scope:", registration.scope);
            })
            .catch(error => {
                console.log("Service Worker registration failed:", error);
            });
    });
}

function updateView() {
    const weapon = document.getElementById("weaponSelect").value;
    const skin = document.getElementById("skinCheck").checked;
    const wrap = document.getElementById("wrapCheck").checked;
    //kontrola
    console.log("Zbran: " + weapon + ", skin: " + skin + ", wrap: " + wrap);

    //slepime nazev obrazku, napr. BR+Skin+Wrap.png
    let imgName = weapon;
    if(weapon !== "Empty") {
        if(skin) imgName += "+Skin";
        if(wrap) imgName += "+Wrap";
    }

    document.getElementById("weaponImg").src = "imgB/" + imgName + ".png";
    document.getElementById("weaponImg").alt = imgName;
}

async function saveFavorite() {
    const weapon = document.getElementById("weaponSelect").value;
    const skin = document.getElementById("skinCheck").checked;
    const wrap = document.getElementById("wrapCheck").checked;

    if(weapon === "Empty") {
        alert("Nejdriv vyber zbran nebo si vyberu ja");
        return;
    }

    try {
        await addFavorite(weapon, skin, wrap);
        alert("Zbran ulozena do oblibenych");
    } catch(error) {
        alert("Chyba pri ukladani zbrane");
    }
}

window.onload = async function() {
    // priprava DB
    await initDB();

    document.getElementById("weaponSelect").addEventListener("change", updateView);
    document.getElementById("skinCheck").addEventListener("change", updateView);
    document.getElementById("wrapCheck").addEventListener("change", updateView);
    document.getElementById("saveBtn").addEventListener("click", saveFavorite);

    //zkusime nacist konfiguraci z URL
    const paramsFromURL = new URLSearchParams(window.location.search);
    const weaponFromURL = paramsFromURL.get("weapon");
    const skinFromURL = paramsFromURL.get("skin");
    const wrapFromURL = paramsFromURL.get("wrap");

    if(weaponFromURL !== null) {
        document.getElementById("weaponSelect").value = weaponFromURL;
    }
    if(skinFromURL !== null) {
        document.getElementById("skinCheck").checked = skinFromURL === "true";
    }
    if(wrapFromURL !== null) {
        document.getElementById("wrapCheck").checked = wrapFromURL === "true";
    }

    updateView();
};
