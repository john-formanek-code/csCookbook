<html>
<head>
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
    <table>
        <tr>
            <th></th>
            <th>Jmeno</th>
            <th>Prijmeni</th>
        </tr>
    <?php

        $jmena = array("Jan", "Karel", "Petr");
        $prijmeni = "Novak";

        for($i = 0; $i < count($jmena); $i++) {
            echo "<tr>";

            echo "<td>" . $i . "</td>";
            echo "<td>" . $jmena[$i] . "</td>";
            echo "<td>" . $prijmeni . "</td>";

            echo "</tr>";
        }
    ?>
    </table>
</body>
</html>