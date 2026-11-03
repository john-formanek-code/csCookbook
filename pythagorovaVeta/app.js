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

function spocitejPythagora() {
    //stahneme do konstant vstupy
    const varianta = document.getElementById("varianta").value;
    const odvesnaA = parseFloat(document.getElementById("odvesna_a").value);
    console.log("A:", odvesnaA);
    const odvesnaB = parseFloat(document.getElementById("odvesna_b").value);
    console.log("B:", odvesnaB);
    const preponaC = parseFloat(document.getElementById("prepona_c").value);
    console.log("C:", preponaC);

    let vysledek;

    if (varianta === "c") {
        if (isNaN(odvesnaA) || isNaN(odvesnaB)) {
            vysledek = "Zadej obě odvěsny";
        } else if (odvesnaA <= 0 || odvesnaB <= 0) {
            vysledek = "Strany musí být kladné";
        } else {
            const soucet = (odvesnaA * odvesnaA) + (odvesnaB * odvesnaB);
            console.log("SOUCET:", soucet);
            const vypocetC = Math.sqrt(soucet);
            vysledek = "Přepona c = " + vypocetC;
        }
    } else if (varianta === "a") {
        if (isNaN(odvesnaB) || isNaN(preponaC)) {
            vysledek = "Zadej odvěsnu b a přeponu c";
        } else if (odvesnaB <= 0 || preponaC <= 0) {
            vysledek = "Strany musí být kladné";
        } else if (preponaC <= odvesnaB) {
            vysledek = "Přepona musí být delší než odvěsna b";
        } else {
            const rozdil = (preponaC * preponaC) - (odvesnaB * odvesnaB);
            console.log("ROZDIL:", rozdil);
            const vypocetA = Math.sqrt(rozdil);
            vysledek = "Odvěsna a = " + vypocetA;
        }
    } else if (varianta === "b") {
        if (isNaN(odvesnaA) || isNaN(preponaC)) {
            vysledek = "Zadej odvěsnu a a přeponu c";
        } else if (odvesnaA <= 0 || preponaC <= 0) {
            vysledek = "Strany musí být kladné";
        } else if (preponaC <= odvesnaA) {
            vysledek = "Přepona musí být delší než odvěsna a";
        } else {
            const rozdil = (preponaC * preponaC) - (odvesnaA * odvesnaA);
            console.log("ROZDIL:", rozdil);
            const vypocetB = Math.sqrt(rozdil);
            vysledek = "Odvěsna b = " + vypocetB;
        }
    } else {
        vysledek = "Neznámá varianta";
    }

    document.getElementById("div_vysledek").innerText = vysledek;
}
