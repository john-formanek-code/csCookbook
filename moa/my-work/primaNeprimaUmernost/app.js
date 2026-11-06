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

function spocitejUmernost() {
    //stahneme hodnoty z poli
    const x1 = parseFloat(document.getElementById("x1").value);
    console.log("x1: " + x1);
    const y1 = parseFloat(document.getElementById("y1").value);
    console.log("y1: " + y1);
    const x2 = parseFloat(document.getElementById("x2").value);
    console.log("x2: " + x2);

    //typ umernosti
    const typ = document.getElementById("typ_umernosti").value;
    console.log("Typ: " + typ);

    let vysledek;

    if (isNaN(x1) || isNaN(y1) || isNaN(x2)) {
        vysledek = "Zadej všechny tři hodnoty";
    } else if (typ === "") {
        vysledek = "Vyber typ úměrnosti";
    } else if (typ === "prima") {
        if (x1 === 0) {
            vysledek = "x1 nesmí být 0";
        } else {
            const y2 = (y1 / x1) * x2;
            console.log("Výpočet přímé: (" + y1 + " / " + x1 + ") * " + x2);
            vysledek = "Přímá úměrnost: y2 = " + y2;
        }
    } else if (typ === "neprima") {
        if (x2 === 0) {
            vysledek = "x2 nesmí být 0";
        } else {
            const y2 = (x1 * y1) / x2;
            console.log("Výpočet nepřímé: (" + x1 + " * " + y1 + ") / " + x2);
            vysledek = "Nepřímá úměrnost: y2 = " + y2;
        }
    } else {
        vysledek = "Neznámý typ";
    }

    document.getElementById("div_vysledek").innerText = vysledek;
}
