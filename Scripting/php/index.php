<!--test-->
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
    <link rel="stylesheet" href="../NewWebsite/index_style.css"/>
<?php
echo "<title>PHP</title>";
?>
</head>
<body>

<?php
for($i =1;$i<32;$i++){

    if($i%2==0){
        echo "<span style='color:red'>";
        }
        for($c=1;$c<=$i;$c++){

        echo "0";
        }
    if($i%2==0){
        echo "</span>";
    }
    echo "<br>";

}

for($i =32;$i!=0;$i--){

    if($i%2==0){
        echo "<span style='color:red'>";
    }
    for($c=1;$c<=$i;$c++){

        echo "0";
    }
    if($i%2==0){
        echo "</span>";
    }
    echo "<br>";

}

$array2 = array("Berlin","Köln","Hamburg");
foreach($array2 as $value){
    echo "Inhalt: $value<br> ";
}

$array = array(
    "apfel" => "grün",
    "Banane" => "gelb",
    "Tomate" => "rot"
);


?>
</body>
</html>