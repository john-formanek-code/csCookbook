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
    if (from === "g" && to === "kg") result = value / 1000;
    else if (from === "kg" && to === "g") result = value * 1000;
    else if (from === "g" && to === "t") result = value / 1000000;
    else if (from === "t" && to === "g") result = value * 1000000;
    else if (from === "kg" && to === "t") result = value / 1000;
    else if (from === "t" && to === "kg") result = value * 1000;
    else result = value;

    document.getElementById("result").innerText =
        value + " " + from + " = " + result + " " + to;
    
    
}
