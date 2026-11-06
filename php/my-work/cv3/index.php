<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="" method="get">
        <input type="text" placeholder="test" minlenght="3" maxlenght="20" required><br>
        <select name="SelectTest" id="">
            <option value="a">AAA</option>
        </select><br> 

        <input type="radio" id="rla" value="rla" name="group1" checked><label for="rla">Radio1</label><br>
        <input type="radio" id="rla" value="rla" name="group1"><label for="rla">Radio2</label><br>

        <input type="radio" id="rla" value="rla" name="group2" checked><label for="rla">Radio1b</label><br>
        <input type="radio" id="rla" value="rla" name="group2"><label for="rla">Radio2b</label><br>

        <input type="checkbox" id="ch1" value="rla" name="group1"><label for="ch1">Radio1</label><br>
        <input type="checkbox" id="ch2" value="rla" name="group1"><label for="ch2">Radio2</label><br>

        <input type="submit">
    </form>    

    <a href="ping.php">Spustit PING PONG</a>
    <a href="pong.php">Spustit PING PONG</a>
</body>
</html>