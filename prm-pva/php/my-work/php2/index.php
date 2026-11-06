<html>
<body>
    <?php
        echo "Hello world!";

        $variable = "text";
        var_dump($variable);

        $variable = 1;
        var_dump($variable);

        echo "<br>";

        $pole = array("prvni", 2, 3.0);
        //var_dump($pole);

        $pole[] = array("4.0", 5, 6.1);

        var_dump($pole);
        echo "<br>";

        //array_pop($pole);
        //array_shift($pole);
        array_splice($pole, 1, 2);
        var_dump($pole);
        echo "<br>";

        //echo $pole[3][1];

        echo "<br>";
        echo "<br>";

        $asocPole = array(
            "prvni" => "text",
            "druha" => "text2",
            "hruska" => "text3",
            "kafe" => "text4"
        );

        unset($asocPole["hruska"]);        
        var_dump($asocPole);

    ?>
</body>
</html>