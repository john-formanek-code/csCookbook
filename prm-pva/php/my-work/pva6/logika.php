<?php

function eratosth($max) {
    // create a array 
    $primes = array();

    // all elemets are marked as TRUE at start
    for($i = 0; $i <= $max; $i++) {
        $primes[$i] = true;
    }
    // 0 is not a prime
    if($max >= 0) {
        $primes[0] = false;
    }
    // 1 is not a prime
    if($max >= 1) {
        $primes[1] = false;
    }

    //start from 2 and the for is about multipliers of 2 and then 3 and etc, continue in the work what is multiplies of the base number is marked as a FALSE
    for($i = 2; $i * $i <= $max; $i++) {
        if($primes[$i] == true) {
            for($j = $i * $i; $j <= $max; $j += $i) {
                $primes[$j] = false;
            }
        }
    }
    return $primes;
}

//call method in the index.php
function drawTable($number) {
    //the number user provide also means how many rows will we have
    $rows = (int)$number;
    // fro each row we create a 10 colloms 
    $max = ($rows * 10) - 1;
    // call a MAin function
    $primes = eratosth($max);

    echo "<table style=\"border: 1px solid black; border-collapse: collapse;\">";
    // how many rows that many tr --- etc. just a amethod to drwa a goddam table
    for($i = 0; $i < $rows; $i++) {
        echo "<tr>";

        for($j = 0; $j < 10; $j++) {
            $value = ($i * 10) + $j;

            echo "<td style=\"border: 1px solid black; padding: 4px;\">";

            if($primes[$value] == true) {
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
