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
    //stahneme zadane hodnoty
    const napeti = parseFloat(document.getElementById("napeti").value);
    console.log("NAPETI: " + napeti);
    const proud = parseFloat(document.getElementById("proud").value);
    console.log("PROUD: " + proud);

    let vysledek;

    if (isNaN(napeti) || isNaN(proud)) {
        vysledek = "Zadej napětí i proud";
    } else {
        //P = U * I
        const vykon = napeti * proud;
        vysledek = "Výkon P = " + vykon + " W";
    }

    document.getElementById("div_vysledek").innerText = vysledek;
}
