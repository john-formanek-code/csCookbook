
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Kalkulacka</title>
</head>
<body>

<?php
    if (isset($_GET["cis_1"], $_GET["cis_2"], $_GET["operace"])) {
        $cis_1 = (int) $_GET["cis_1"];
        $cis_2 = (int) $_GET["cis_2"];
        $operace = $_GET["operace"];

        switch ($operace) {
            case "+":
                $vysledek = $cis_1 + $cis_2;
                break;

            case "-":
                $vysledek = $cis_1 - $cis_2;
                break;

            case "*":
                $vysledek = $cis_1 * $cis_2;
                break;

            case "%":
                if ($cis_2 != 0) {
                    $vysledek = $cis_1 % $cis_2;
                } else {
                    $vysledek = "Nelze delit nulou";
                }
                break;

            default:
                $vysledek = "Neplatna operace";
        }

        echo "<h2>Vysledek: $vysledek</h2>";
    }
?>

<form action="" method="get">
    <input type="number" name="cis_1"
           placeholder="cislo 1" max="1000" required>
    <br>

    <select name="operace">
        <option value="+">+</option>
        <option value="-">-</option>
        <option value="%">%</option>
        <option value="*">*</option>
    </select>
    <br>

    <input type="number" name="cis_2"
           placeholder="cislo 2" max="1000" required>
    <br>

    <input type="submit" value="Vypocitat">
</form>

</body>
</html>
