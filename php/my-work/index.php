<html>
    <head>

    </head>
    <body>
        <h1>Hello</h1>
        <?php

        function row(){
            echo "<br>";
        }
        function vypisCislo($a, $b) {
            for ($i = $a; $i <= $b; $i++) {
                echo $i . "<br>"; // Přidán středník na konci
            }
        }
        echo "Hello world"; 

        $var = "Muj variable";

        echo "<br>";

        var_dump($var);

        // Indexované pole 
        $pole = array(2, "string");
        //stejný ale novější verze
        $array = [1, "string"];

        // Asociativní pole
        $uzivatel = [
            "jmeno" => "Jan",
            "prijmeni" => "Novák",
            "vek" => 28,
            "pohlavi" => true
        ];

        nl2br();






        ?>
</html>