<?php
/**
 * Created by IntelliJ IDEA.
 * User: KNapret
 * Date: 10.12.2015
 * Time: 14:49
 */



$karte = [
    'Pizzen' => [
        'Margherita' => [
            'normal' => 4,
            'groß' => 6],

        'Funghi' => [
            'normal' => 5,
            'groß' => 7],

        'Salami' =>[
            'normal' => 5.5,
            'groß' => 7.5],

        'Regina' =>[
            'normal' => 5.5,
            'groß' => 7.5],

        'Hawaii' =>[
            'normal' => 6.5,
            'groß' => 8.5]
    ],
    'Getränk'=>[
        'Cola' => 2,
        'Fanta'=> 2,
        'Spezi'=> 2,
        'Wasser'=> 1.5
    ]
];
?>


<form method="post">
    <?php
    foreach($karte['Pizzen'] as $key => $value){

        echo "<input type='radio' value='$key' name='Pizza'>$key<br>";
    }
    ?>

    <br>

    <input type="radio" value="normal" name="Größe">normal
    <input type="radio" value="groß" name =Größe>groß

    <br><br>

    <input type="checkbox" value="Cola" name="getränk[]">Cola <br>
    <input type="checkbox" value="Fanta" name="getränk[]">Fanta <br>
    <input type="checkbox" value="Spezi" name="getränk[]">Spezi <br>
    <input type="checkbox" value="Wasser" name="getränk[]">Wasser <br>

    <br><br>
    <input type="text" name="tischnummer" placeholder="Tischnummer"><br>

    <button type="submit">Bestellung abschicken</button>


</form>
<hr>
<?php
if(isset($_POST['tischnummer'])){
    $summe =0;
    $pizza =$_POST['Pizza'];
    $groeße = $_POST['Größe'];


    $summe=$karte['Pizzen'][$pizza][$groeße];

    if(isset($_POST['getränk'])){
        $getraenke = $_POST['getränk'];
        foreach ($getraenke as $getraenk) {

            $summe+=$karte['Getränk'][$getraenk];
        }
    }



    echo "Die Gesamtsummer Ihrer Bestellung beträgt: ".$summe." €<br>";

    echo "Die Bestellung läuft auf Tisch ".$_POST['tischnummer'];






}

?>


