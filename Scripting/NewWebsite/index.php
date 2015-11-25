<?php
    $pages= [
        'home' => 'Allgemeines',
        'lists' => 'Listen',
        'tables' => 'Tabellen',
        'impressum' => 'Impressum',
        'formulare' => 'Formulare'
    ];

if(isset($_GET['page'])|| isset($pages[$_GET['page']])){
    $currentPage = $_GET['page'];
}else{
    $currentPage = 'home';
}
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
        echo "<div id='main'>";
        require 'navigation.php';
        require 'content.php';
        echo "</div>";
        require 'foot.php';
        ?>



</body>
</html>
