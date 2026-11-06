if("serviceWorker" in navigator) {
    window.addEventListener("load",() => {
        navigator.serviceWorker.register("/sw.js")
        .then(registration => {
            console.log("Service Worker register with scope: ", registration)
        })
        .catch(error => {
            console.log("Service Worker registration failed: ", error)
        })
    })
}

function pocitej() {
    let value = Number(document.getElementById("value").value);
    const from = document.getElementById("from").value;
    const to = document.getElementById("to").value;
    let result = 0;

    if (value == "") {
        document.getElementById("result").innerText = "Zadejte hodnotu!";
        return;
    }
    if (from === "m" && to === "km") result = value / 1000;
    else if (from === "km" && to === "m") result = value * 1000;
    else if (from === "m" && to === "mm") result = value * 1000;
    else if (from === "mm" && to === "m") result = value / 1000;
    else if (from === "mm" && to === "km") result = value / 1000000;
    else if (from === "km" && to === "mm") result = value * 1000000;
    else result = value;

    document.getElementById("result").innerText =
        value + " " + from + " = " + result + " " + to;
    
    
}
