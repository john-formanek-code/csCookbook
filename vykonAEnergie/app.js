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

function spocitejVykon() {
    //stahneme hodnoty
    const napeti = parseFloat(document.getElementById("napeti").value);
    console.log("NAPETI:", napeti);
    const proud = parseFloat(document.getElementById("proud").value);
    console.log("PROUD:", proud);
    const vykon = parseFloat(document.getElementById("vykon").value);
    console.log("VYKON:", vykon);

    const maNapeti = !isNaN(napeti);
    const maProud = !isNaN(proud);
    const maVykon = !isNaN(vykon);
    const pocetVyplnenych = (maNapeti ? 1 : 0) + (maProud ? 1 : 0) + (maVykon ? 1 : 0);
    console.log("POCET:", pocetVyplnenych);

    let vysledek;

    if (pocetVyplnenych < 2) {
        vysledek = "Zadej dvě hodnoty";
    } else if (pocetVyplnenych > 2) {
        vysledek = "Nech jednu kolonku prázdnou";
    } else if (!maNapeti) {
        if (proud === 0) {
            vysledek = "Proud nesmí být nula";
        } else {
            const vypocteneNapeti = vykon / proud;
            vysledek = "Napětí U = " + vypocteneNapeti + " V";
        }
    } else if (!maProud) {
        if (napeti === 0) {
            vysledek = "Napětí nesmí být nula";
        } else {
            const vypoctenyProud = vykon / napeti;
            vysledek = "Proud I = " + vypoctenyProud + " A";
        }
    } else {
        const vypoctenyVykon = napeti * proud;
        vysledek = "Výkon P = " + vypoctenyVykon + " W";
    }

    document.getElementById("div_vysledek").innerText = vysledek;
}
