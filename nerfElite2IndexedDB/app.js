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

function updateView() {
    const primary = document.getElementById("primarySelect").value;
    const secondary = document.getElementById("secondarySelect").value;

    document.getElementById("primaryImg").src = "img/" + primary + ".png";
    document.getElementById("secondaryImg").src = "img/" + secondary + ".png";
    document.getElementById("primaryImg").alt = primary;
    document.getElementById("secondaryImg").alt = secondary;
}

async function saveFavorite() {
    const primary = document.getElementById("primarySelect").value;
    const secondary = document.getElementById("secondarySelect").value;

    if(primary === "Empty" && secondary === "Empty") {
        alert("Kombinace Empty + Empty nejde ulozit");
        return;
    }

    try {
        await addFavorite(primary, secondary);
        alert("Kombinace ulozena do oblibenych");
    } catch(error) {
        alert("Chyba pri ukladani kombinace");
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
