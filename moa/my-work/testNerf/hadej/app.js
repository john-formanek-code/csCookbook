const numberInput = document.getElementById("cislo");
const resultDiv = document.getElementById("vysledek");

let secretNumber;
let tryCount;

function reset() {
    tryCount = 0;
    secretNumber = Math.floor(Math.random() * 10) + 1;
    cosnole.log("Nove tajne cislo je: " + secretNumber);
    resultDiv.innerText = "Zadej cislo od 1 do 10";
}