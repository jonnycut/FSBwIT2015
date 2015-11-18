<?php
    $pages= [
        'home' => 'Allgemeines',
        'lists' => 'Listen',
        'tables' => 'Tabellen'
    ]
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="dynamic_style.css"/>

</head>
<body>
    <?php
    require 'head.php';
    require 'navigation.php';
    require 'content.php';
    require 'foot.php';


    ?>
</body>
</html>
