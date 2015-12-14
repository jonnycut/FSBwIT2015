<?php
/**
 * Created by IntelliJ IDEA.
 * User: JonnyCut
 * Date: 14.12.2015
 * Time: 20:15
 */

?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="dynamic_style.css"/>

</head>
<body>


<div style="display: inline-block;border: solid 1px;padding: 8px">
<form action="berechnung.php" method=post>
    <input type="text" placeholder="eingabe" name="eingabe">
    <input type="radio" value="Meilen" name="art">Meilen
    <input type="radio" value="Kilometer" checked name="art">Kilometer

    <input type="submit" value="Umrechnen" name="Umrechnen">

    <?php

    ?>

</form>
</div>




</body>
</html>

