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
window.onload = async function() {
    // priprava Db
    await initDB();

    //nacteni a vypis vsech zbrani
    const favorites = await getAllFavorites();
    const div = document.getElementById("favoritesList");
    // kontrola jestli mam nejakou poznamku ulozenou 
    if(favorites.length === 0) {
        div.innerHTML = "<p class='empty-message'>nejsou uloženy žádné oblíbené kombinace</p>";
        return;
    }

    let html = "";

    for(let i = 0; i < favorites.length; i++) {
        const item = favorites[i];
        const id = item.id;
        const primary = item.primary;
        const secondary = item.secondary;

        html += "<div class='favorite-row'>";
        html += "<button class='favorite-pick' onclick='openFavorite(\"" + primary + "\", \"" + secondary + "\")'>";
        html += primary + " + " + secondary + "</button>";
        html += "<button class='delete-btn' onclick='removeFavorite(" + id + ")'>Smazat</button>";
        html += "</div>\n";
    }

    div.innerHTML = html;
};

function openFavorite(primary, secondary) {
    window.location.href = "index.html?primary=" + encodeURIComponent(primary) + "&secondary=" + encodeURIComponent(secondary);
}

async function removeFavorite(id) {
    await deleteFavorite(id);
    location.reload();
}
