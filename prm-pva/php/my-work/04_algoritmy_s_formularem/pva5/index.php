<html>
<body>
    <form method="GET" action="index.php">
        Number: <input type="number" name="number"><br>
        <button type="submit">Odeslat</button>
    </form>

    <?php
        require_once "logika.php";

        if(array_key_exists("number", $_GET)) {
            drawTable($_GET["number"]);
        }
    ?>
</body>
</html>
