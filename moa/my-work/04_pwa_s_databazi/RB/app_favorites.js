// Registrace Service Workeru
if("serviceWorker" in navigator) {
    navigator.serviceWorker.register("./sw.js");
}

window.onload = async function() {
    try {
        await initDB();
        const favorites = await getAllFavorites();
        const div = document.getElementById("favoritesList");

        if(favorites.length === 0) {
            div.innerHTML = "<p>Zatím nemáš žádné uložené zbraně</p>";
            return;
        }

        let html = "";

        for(let i = 0; i < favorites.length; i++) {
            const item = favorites[i];
            let nazev = item.weapon;

            if(nazev === "BR") {
                nazev = "BR";
            }
            if(item.skin) {
                nazev += "+Skin";
            }
            if(item.wrap) {
                nazev += "+Wrap";
            }

            html += "<div class='favoriteRow'>";
            html += "<button class='favoriteButton' onclick='openFavorite(" + item.id + ")'>" + nazev + "</button>";
            html += "<button class='deleteButton' onclick='removeFavorite(" + item.id + ")'>Smazat</button>";
            html += "</div>";
        }

        div.innerHTML = html;
    } catch(error) {
        document.getElementById("favoritesList").innerText = "Nepodařilo se načíst oblíbené";
    }
};

// Po kliknuti predame ulozenou konfiguraci na prvni stranku
async function openFavorite(id) {
    const favorites = await getAllFavorites();

    for(let i = 0; i < favorites.length; i++) {
        if(favorites[i].id === id) {
            const item = favorites[i];
            window.location.href = "index.html?weapon=" + item.weapon + "&skin=" + item.skin + "&wrap=" + item.wrap;
            return;
        }
    }
}

async function removeFavorite(id) {
    try {
        await deleteFavorite(id);
        location.reload();
    } catch(error) {
        alert("Chyba při mazání zbraně");
    }
}
