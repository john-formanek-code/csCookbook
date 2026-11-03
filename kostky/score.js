//registrace service workeru
if ("serviceWorker" in navigator) {
    window.addEventListener("load", () => {
        navigator.serviceWorker.register("./sw.js");
    });
}

//po nacteni stranky
window.onload = async function() {
    let hrac_score = parseInt(localStorage.getItem("hrac_score")) || 0;
    let pocitac_score = parseInt(localStorage.getItem("pocitac_score")) || 0;

    document.getElementById("score_label").innerText = hrac_score + " : " + pocitac_score;

    try {
        await initDB();
        const historie = await getAllGames();
        const div = document.getElementById("historie_label");

        if (historie.length === 0) {
            div.innerText = "Zatím žádné hry";
        } else {
            let seznam = "<ul>";
            for (let i = historie.length - 1; i >= 0; i--) {
                seznam += "<li>" + historie[i].cil + " / " + historie[i].hrac + " / "
                    + historie[i].pocitac + " - " + historie[i].vysledek + "</li>";
            }
            seznam += "</ul>";
            div.innerHTML = seznam;
        }
    } catch (error) {
        console.log("Chyba pri nacteni historie:", error);
        document.getElementById("historie_label").innerText = "Chyba při načítání historie";
    }
}

//reset skore a cele historie
async function reset() {
    localStorage.setItem("hrac_score", 0);
    localStorage.setItem("pocitac_score", 0);

    try {
        await initDB();
        await deleteAllGames();
    } catch (error) {
        console.log("Chyba pri mazani historie:", error);
    }

    location.reload();
}
