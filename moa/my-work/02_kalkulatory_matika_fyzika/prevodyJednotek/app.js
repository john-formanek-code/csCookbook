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

//jednoduche tabulky pro prevody, staci upravit koeficienty
const prevodnaPravidla = {
    "m_km": { vstup: "metrů", vystup: "kilometrů", koef: 0.001 },
    "km_m": { vstup: "kilometrů", vystup: "metrů", koef: 1000 },
    "m_cm": { vstup: "metrů", vystup: "centimetrů", koef: 100 },
    "cm_m": { vstup: "centimetrů", vystup: "metrů", koef: 0.01 },
    "kg_g": { vstup: "kilogramů", vystup: "gramů", koef: 1000 },
    "g_kg": { vstup: "gramů", vystup: "kilogramů", koef: 0.001 },
    "l_ml": { vstup: "litrů", vystup: "mililitrů", koef: 1000 },
    "ml_l": { vstup: "mililitrů", vystup: "litrů", koef: 0.001 }
};

function prevodJednotek() {
    //stahneme hodnotu k prevodu
    const hodnota = parseFloat(document.getElementById("vstupni_hodnota").value);
    console.log("Hodnota: " + hodnota);

    //stahneme typ prevodu
    const typPrevodu = document.getElementById("typ_prevodu").value;
    console.log("Typ převodu: " + typPrevodu);

    let vysledek;

    if (isNaN(hodnota)) {
        vysledek = "Zadej číslo pro převod";
    } else if (!prevodnaPravidla[typPrevodu]) {
        vysledek = "Vyber převod ze seznamu";
    } else {
        const pravidlo = prevodnaPravidla[typPrevodu];
        const prevedenaHodnota = hodnota * pravidlo.koef;
        console.log("Výpočet: " + hodnota + " * " + pravidlo.koef);
        vysledek = hodnota + " " + pravidlo.vstup + " = " + prevedenaHodnota + " " + pravidlo.vystup;
    }

    document.getElementById("div_vysledek").innerText = vysledek;
}
