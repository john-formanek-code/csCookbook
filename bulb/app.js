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

function spocitejOhm() {
    //stahneme do konstant zadani
    const varianta = document.getElementById("varianta").value;
    const proud = parseFloat(document.getElementById("proud").value);
    console.log("PROUD:", proud);
    const odpor = parseFloat(document.getElementById("odpor").value);
    console.log("ODPOR:", odpor);
    const napeti = parseFloat(document.getElementById("napeti").value);
    console.log("NAPETI:", napeti);

    let vysledek;

    switch (varianta) {
        case "u":
            if (isNaN(proud) || isNaN(odpor)) {
                vysledek = "Zadej proud i odpor";
            } else {
                const vypocetU = proud * odpor;
                console.log("U:", vypocetU);
                vysledek = "Napětí U = " + vypocetU + " V";
            }
            break;
        case "i":
            if (isNaN(napeti) || isNaN(odpor)) {
                vysledek = "Zadej napětí i odpor";
            } else if (odpor === 0) {
                vysledek = "Nelze dělit odporem 0";
            } else {
                const vypocetI = napeti / odpor;
                console.log("I:", vypocetI);
                vysledek = "Proud I = " + vypocetI + " A";
            }
            break;
        case "r":
            if (isNaN(napeti) || isNaN(proud)) {
                vysledek = "Zadej napětí i proud";
            } else if (proud === 0) {
                vysledek = "Nelze dělit proudem 0";
            } else {
                const vypocetR = napeti / proud;
                console.log("R:", vypocetR);
                vysledek = "Odpor R = " + vypocetR + " Ω";
            }
            break;
        default:
            vysledek = "Neznámá varianta";
    }

    document.getElementById("div_vysledek").innerText = vysledek;
}
