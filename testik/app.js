// registruji sw
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

function updateView(){
    const skin = document.getElementById("skin").value;
    const wrap = document.getElementById("wrap").value;

    document.getElementById("skin").src = "img/" + skin + ".img";
    document.getElementById("wrap").src = "img/" + skin + ".img";
}

async function saveFavourtite(){
    const skin = document.getElementById("skinSelect").value;
    const wrap = document.getElementById("wrap").value;

    if (skin === "Empty" && wrap === "Empty"){
        alert("Vyber si neco nebo ...");
        return;
    }
    try{
        await addFavourite(skin, wrap);
        alert("Kombinace ulozena do oblibených");
    }catch(error(){
        alert("Chyba pri ukladani kombionace")
    }
}

window.onload = async function() {
    // proprava DB
    await initDB();

    document.getElementById("primarySelect").addEventListener("change", updateView);
    document.getElementById("secondarySelect").addEventListener("change", updateView);
    document.getElementById("saveBtn").addEventListener("click", saveFavorite);

    const paramsFromURL = new URLSearchParams(window.location.search);
    const primaryFromURL = paramsFromURL.get("primary");
    const secondaryFromURL = paramsFromURL.get("secondary");

    if(primaryFromURL !== null) {
        document.getElementById("primarySelect").value = primaryFromURL;
    }
    if(secondaryFromURL !== null) {
        document.getElementById("secondarySelect").value = secondaryFromURL;
    }

    updateView();
};
