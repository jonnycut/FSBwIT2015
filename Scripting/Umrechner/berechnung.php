<?php
/**
 * Created by IntelliJ IDEA.
 * User: JonnyCut
 * Date: 14.12.2015
 * Time: 20:35
 */

if($_POST['art']=='Kilometer'){

    $km = $_POST['eingabe'];
    $meilen = $km /1.6;

    echo "$km Kilometer sind $meilen Meilen";
}elseif($_POST['art']=='Meilen'){

    $meilen = $_POST['eingabe'];
    $km = $meilen * 1.6;
    echo "$meilen Meilen sind $km Kilometer";
}else{
    echo "NIX IS SET JUNGE";
}

echo "<br><br><a href='index.php'>zurück</a>";


?>