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
    // kontrola jestli mam nejakou zbran ulozenou
    if(favorites.length === 0) {
        div.innerHTML = "<p class='empty-message'>nejsou uloženy žádné oblíbené zbraně</p>";
        return;
    }

    let html = "";

    for(let i = 0; i < favorites.length; i++) {
        const item = favorites[i];
        const id = item.id;
        const weapon = item.weapon;
        const skin = item.skin;
        const wrap = item.wrap;

        //popisek zbrane
        let popis = weapon === "BR" ? "Burst Rifle" : weapon;
        if(skin) popis += " + Skin";
        if(wrap) popis += " + Wrap";

        html += "<div class='favorite-row'>";
        html += "<button class='favorite-pick' onclick='openFavorite(\"" + weapon + "\", " + skin + ", " + wrap + ")'>";
        html += popis + "</button>";
        html += "<button class='delete-btn' onclick='removeFavorite(" + id + ")'>Smazat</button>";
        html += "</div>\n";
    }

    div.innerHTML = html;
};

function openFavorite(weapon, skin, wrap) {
    window.location.href = "index.html?weapon=" + encodeURIComponent(weapon) + "&skin=" + skin + "&wrap=" + wrap;
}

async function removeFavorite(id) {
    await deleteFavorite(id);
    location.reload();
}
