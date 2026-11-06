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

function spocitejProcenta() {
    const varianta = document.getElementById("varianta").value;
    const procento = parseFloat(document.getElementById("procento").value);
    console.log("PROCENTA:", procento);
    const zaklad = parseFloat(document.getElementById("zaklad").value);
    console.log("ZAKLAD:", zaklad);
    const cast = parseFloat(document.getElementById("cast").value);
    console.log("CAST:", cast);
    const pomerA = parseFloat(document.getElementById("pomer_a").value);
    console.log("POMER_A:", pomerA);
    const pomerB = parseFloat(document.getElementById("pomer_b").value);
    console.log("POMER_B:", pomerB);

    let vysledek;

    if (varianta === "procento") {
        if (isNaN(procento) || isNaN(zaklad)) {
            vysledek = "Zadej procenta i základ";
        } else {
            const vypocet = (procento / 100) * zaklad;
            vysledek = procento + "% z " + zaklad + " je " + vypocet;
        }
    } else if (varianta === "zaklad") {
        if (isNaN(procento) || isNaN(cast)) {
            vysledek = "Zadej část i procenta";
        } else if (procento === 0) {
            vysledek = "Nelze dělit procentem 0";
        } else {
            const vypocetZaklad = (cast * 100) / procento;
            vysledek = cast + " je " + procento + "% ze " + vypocetZaklad;
        }
    } else if (varianta === "pomer") {
        if (isNaN(pomerA) || isNaN(pomerB)) {
            vysledek = "Zadej obě čísla poměru";
        } else if (pomerA === 0 && pomerB === 0) {
            vysledek = "Obě čísla nemohou být 0";
        } else {
            const absolutA = Math.abs(pomerA);
            const absolutB = Math.abs(pomerB);
            let gcd = 1;
            let x = absolutA;
            let y = absolutB;
            while (y !== 0) {
                const temp = y;
                y = x % y;
                x = temp;
            }
            gcd = x === 0 ? 1 : x;
            const zjednoduseneA = pomerA / gcd;
            const zjednoduseneB = pomerB / gcd;
            vysledek = "Poměr " + pomerA + ":" + pomerB + " = " + zjednoduseneA + ":" + zjednoduseneB;
        }
    } else {
        vysledek = "Neznámá varianta";
    }

    document.getElementById("div_vysledek").innerText = vysledek;
}
