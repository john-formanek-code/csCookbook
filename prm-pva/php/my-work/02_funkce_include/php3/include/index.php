<html>
<body>
    <h3>Zacatek stranky</h3>

    <?php
    echo "echo1";

    include "soubor3.php";
    include_once "soubor.php";

    require "soubor2.php";
    require_once "soubor2.php";
    require "soubor3.php";

    echo "<br>echo2";
    ?>

    <h3>Konec stranky stranky</h3>
</body>
</html>