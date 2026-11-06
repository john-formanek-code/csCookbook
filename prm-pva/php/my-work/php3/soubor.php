<?php
function myFunction($param1, $param2) {
    return "end";
}

function printNumbers($start, $stop){
    for($i = $start; $i <= $stop; $i++) {
        echo "<br>" . $i;
    }
}

function arguments($a, $b, ...$num) {
    $numberCount = count($num);

    echo "pocet args: " . $numberCount;
    for($i = 0; $i < $numberCount; $i++) {
        echo "<br>" . $num[$i];
    }
}

function bigFamily($lastname, ...$firstnames) {
    for($prijmeni = 0; $prijmeni < count($firstnames); $prijmeni++) {
        echo "<br>Firstname: " . $firstnames[$prijmeni] .
        " lastname: " . $lastname;
    }
}
?>