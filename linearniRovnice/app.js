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

function spocitejLinearni() {
    const typ = document.getElementById("typ_vypoctu").value;
    const koefA = parseFloat(document.getElementById("koef_a").value);
    console.log("KOEF_A:", koefA);
    const koefB = parseFloat(document.getElementById("koef_b").value);
    console.log("KOEF_B:", koefB);
    const a1 = parseFloat(document.getElementById("a1").value);
    console.log("A1:", a1);
    const b1 = parseFloat(document.getElementById("b1").value);
    console.log("B1:", b1);
    const c1 = parseFloat(document.getElementById("c1").value);
    console.log("C1:", c1);
    const a2 = parseFloat(document.getElementById("a2").value);
    console.log("A2:", a2);
    const b2 = parseFloat(document.getElementById("b2").value);
    console.log("B2:", b2);
    const c2 = parseFloat(document.getElementById("c2").value);
    console.log("C2:", c2);

    let vysledek;

    if (typ === "linearni") {
        if (isNaN(koefA) || isNaN(koefB)) {
            vysledek = "Zadej koeficienty a i b";
        } else if (koefA === 0 && koefB === 0) {
            vysledek = "Rovnice má nekonečně mnoho řešení";
        } else if (koefA === 0) {
            vysledek = "Koeficient a nesmí být 0";
        } else {
            const x = -koefB / koefA;
            console.log("X:", x);
            vysledek = "Řešení rovnice x = " + x;
        }
    } else if (typ === "soustava") {
        if (isNaN(a1) || isNaN(b1) || isNaN(c1) || isNaN(a2) || isNaN(b2) || isNaN(c2)) {
            vysledek = "Zadej všechny koeficienty soustavy";
        } else {
            const determinant = (a1 * b2) - (a2 * b1);
            console.log("DET:", determinant);
            if (determinant === 0) {
                vysledek = "Determinant je 0, řešení není jednoznačné";
            } else {
                const determinantX = (c1 * b2) - (c2 * b1);
                const determinantY = (a1 * c2) - (a2 * c1);
                console.log("DET_X:", determinantX);
                console.log("DET_Y:", determinantY);
                const x = determinantX / determinant;
                const y = determinantY / determinant;
                vysledek = "Řešení soustavy: x = " + x + ", y = " + y;
            }
        }
    } else {
        vysledek = "Neznámý typ výpočtu";
    }

    document.getElementById("div_vysledek").innerText = vysledek;
}
