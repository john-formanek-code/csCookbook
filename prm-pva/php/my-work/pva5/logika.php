<?php

function isPrime($number) {
    if($number < 2) {
        return false;
    }

    for($i = 2; $i * $i <= $number; $i++) {
        if($number % $i == 0) {
            return false;
        }
    }

    return true;
}

function drawTable($number) {
    $rows = (int)$number;

    echo "<table style=\"border: 1px solid black; border-collapse: collapse;\">";

    for($i = 0; $i < $rows; $i++) {
        echo "<tr>";

        for($j = 0; $j < 10; $j++) {
            $value = ($i * 10) + $j;

            echo "<td style=\"border: 1px solid black; padding: 4px;\">";

            if(isPrime($value)) {
                echo "<b>" . $value . "</b>";
            } else {
                echo $value;
            }

            echo "</td>";
        }

        echo "</tr>";
    }

    echo "</table>";
}

?>
