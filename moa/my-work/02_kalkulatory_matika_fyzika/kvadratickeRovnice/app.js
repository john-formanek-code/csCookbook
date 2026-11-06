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

function spocitejKvadratickou() {
    //stahneme do konstant koeficienty
    const koeficientA = parseFloat(document.getElementById("koeficient_a").value);
    console.log("KOEF_A: " + koeficientA);
    const koeficientB = parseFloat(document.getElementById("koeficient_b").value);
    console.log("KOEF_B: " + koeficientB);
    const koeficientC = parseFloat(document.getElementById("koeficient_c").value);
    console.log("KOEF_C: " + koeficientC);

    let vysledek;

    if (isNaN(koeficientA) || isNaN(koeficientB) || isNaN(koeficientC)) {
        vysledek = "Zadej všechny koeficienty";
    } else if (koeficientA === 0) {
        vysledek = "Koeficient a nesmí být 0";
    } else {
        const diskriminant = (koeficientB * koeficientB) - (4 * koeficientA * koeficientC);
        console.log("DISK: " + diskriminant);

        if (diskriminant < 0) {
            vysledek = "Diskriminant D = " + diskriminant + ", reálné kořeny neexistují";
        } else if (diskriminant === 0) {
            const kořen = -koeficientB / (2 * koeficientA);
            console.log("KOREN: " + kořen);
            vysledek = "D = 0, dvojnásobný kořen x = " + kořen;
        } else {
            const odmocninaD = Math.sqrt(diskriminant);
            const koren1 = (-koeficientB + odmocninaD) / (2 * koeficientA);
            const koren2 = (-koeficientB - odmocninaD) / (2 * koeficientA);
            console.log("KOREN1: " + koren1);
            console.log("KOREN2: " + koren2);
            vysledek = "D = " + diskriminant + ", x1 = " + koren1 + ", x2 = " + koren2;
        }
    }

    document.getElementById("div_vysledek").innerText = vysledek;
}
