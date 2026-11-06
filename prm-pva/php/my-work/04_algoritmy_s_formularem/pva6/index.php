<html>
<body>
    // create a form - number as a input param - action button send by method GET
    <form method="GET" action="index.php">
        Number: <input type="number" name="number"><br>
        <button type="submit">Odeslat</button>
    </form>

    // you need the file with logic of the program - verify if the user provide a number - if yes we call a drawTable method
    <?php
        require_once "logika.php";
        if(array_key_exists("number", $_GET)) {
            drawTable($_GET["number"]);
        }
    ?>
</body>
</html>
