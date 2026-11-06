<html>
<body>
    <form method="GET" action="index.php">
            Lastname: <input type="text" name="lastname"><br>
            Name 1: <input type="text" name="name1"><br>
            Name 2: <input type="text" name="name2"><br>
            Name 3: <input type="text" name="name3"><br>
            Name 4: <input type="text" name="name4"><br>
            Name 5: <input type="text" name="name5"><br>
            Name 6: <input type="text" name="name6"><br>
            Number: <input type="number" name="number"><br>
            <input type="submit">
    </form>

    <?php
    function bigFamily($lastname, ...$firstnames) {
        for($prijmeni = 0; $prijmeni < count($firstnames); $prijmeni++) {
            echo "<br>Firstname: " . $firstnames[$prijmeni] .
            " lastname: " . $lastname;
        }
    }

    if(array_key_exists("lastname", $_GET)) {
        echo "Lastname exist <br>";
    } else {
        exit();
    }

    if($_GET["name1"] == "") {
        echo "Name 1 empty <br>";
    }

    if(empty($_GET["name2"])) {
        echo "Name 2 empty <br>";
    }

    bigFamily(
        $_GET["lastname"], $_GET["name1"], $_GET["name2"],
        $_GET["name3"],$_GET["name4"], $_GET["name5"], $_GET["name6"]
    );

    ?>
</body>
</html>