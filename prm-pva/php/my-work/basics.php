<!DOCTYPE html>
<html>
<head>

</head>

<body>

<h1>Hello world! 1 </h1>

<?php
	$variable = 10;
    echo "<p>" . $variable . "</p>";
    var_dump($variable);
    
    $variable = "text";
    echo "<p> $variable </p>";
    var_dump($variable);
    ?>    
    
    <table style="border: 1px solid black">
    
    <?php
    for($i = 0; $i < 5; $i++) {
    	echo "<tr>";
    	for($j = 0; $j < 5; $j++) {
    		echo "<td> " . ($i + $j) . " </td>";
    	}
        echo "</tr>";
    }
	?>
	</table>
    
    
    <?php        
        $pole = array("Prvni", 3.5, "Treti");
        var_dump($pole);
        
        $pole[] = "Ctvrty";
        var_dump($pole);
        
        
        
        foreach($pole as $x) {
        	echo '<p>' . $x . '</p>';
        }
    ?>

</body>
</html>
