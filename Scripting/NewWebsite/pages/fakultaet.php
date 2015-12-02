<?php

$zahl = "";
if (isset($_GET['zahl'])) {
    $zahl =  $_GET['zahl'];
}
?>


<form action="" method="get">
    <input type="Search for" value="<?=$zahl?>" name="zahl"><br>
    <button type="submit">Suche</button>
    <input type="reset" value="Reset">
    <input type="hidden" name="page" value="fakultaet">
</form>

<?php

if(isset($_GET['zahl'])){

    if(is_numeric($zahl)){
        $n=$zahl;

        function fak($n){

            if($n>0){
                return $n * fak($n-1);
            }else{
                return 1;
            }

       }

        echo fak($_GET['zahl']);



    } else{
        echo "<h1> Bitte geben Sie eine Zahl ein</h1>";
    }

}