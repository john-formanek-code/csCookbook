
<?php
    if(isset($_POST["reset"])) {
        unset($_POST["number1"]);
        unset($_POST["number2"]);
        unset($_POST["number3"]);

        unset($_COOKIE["M"]);
        unset($_COOKIE["N"]);
        unset($_COOKIE["COUNT"]);

        setcookie("M", "", time() - 3600);
        setcookie("N", "", time() - 3600);
        setcookie("COUNT", "", time() - 3600);

        header("Location: index.php");
        exit;
    }

    if(isset($_POST["number1"])) {
        $M = $_POST["number1"];
        $N = $_POST["number2"];
        $COUNT = $_POST["number3"];

        setcookie("M", $M);
        setcookie("N", $N);
        setcookie("COUNT", $COUNT);
    }
?>

<html>
    <head>
    </head>
    <body>
        <form method="POST" action="index.php">
            <input type="number" id="number1" name="number1" required placeholder="Cislo M"
                value="<?= htmlspecialchars($_POST['number1'] ?? $_COOKIE['M'] ?? '') ?>">

            <input type="number" id="number2" name="number2" required placeholder="Cislo N"
                value="<?= htmlspecialchars($_POST['number2'] ?? $_COOKIE['N'] ?? '') ?>">

            <input type="number" id="number3" name="number3" required placeholder="Pocet des. mist"
                value="<?= htmlspecialchars($_POST['number3'] ?? $_COOKIE['COUNT'] ?? '') ?>">

            <br>
            <input type="submit" value="Vypocitat">
            <button type="submit" name="reset" value="1" formnovalidate>Reset</button>
        </form>

        <?php
            // nacti data do php promennych
            if(isset($_POST["number1"])) {
                $M = $_POST["number1"];
                $N = $_POST["number2"];
                $COUNT = $_POST["number3"];

                if($N != 0) {
                    $result = (int)($M / $N);
                    $reminder = $M % $N;

                    $M = $reminder * 10;
                    echo "result: " . $result . ", <br>";

                    for($i = 0; $i < $COUNT; $i++) {
                        $digit = (int)($M / $N);
                        echo $digit;

                        if(($i + 1) % 10 == 0) {
                            echo "<br>";
                        }

                        $reminder = $M % $N;
                        $M = $reminder * 10;
                    }
                }
            }
        ?>
    </body>
</html>
