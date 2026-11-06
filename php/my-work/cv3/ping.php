
<!DOCTYPE html>
<html lang="cs">
<head>
    <meta charset="UTF-8">
    <title>Ping</title>
</head>
<body>

<?php
if (isset($_GET["id"])) {
    // Neni prvni navsteva
    $id = (int) $_GET["id"];
} else {
    // Prvni navsteva
    $id = rand(1, 100);
}

if (isset($_GET["cnt"])) {
    // Neni prvni navsteva
    $cnt = (int) $_GET["cnt"] + 1;
} else {
    // Prvni navsteva
    $cnt = 0;
}

echo "ID: " . $id . "<br>";
echo "Count: " . $cnt . "<br>";

echo "<a href='pong.php?id=$id&cnt=$cnt'>PONG</a>";
?>

</body>
</html>
