
<!-- ToDo: Ausgabe richtig anpassen 11.11.2015 DONE-->

<?php
$array_autos = array(
    "Alfred" => [
        "Audi A4" => ["Schwarz", "180 PS", "2 Jahre"]
    ],
    "Ingrid" => [
        "VW Käfer" => ["Gelb", "110 PS", "6 Jahre"]
    ],
    "Lisa" => [
        "VW Lupo" => ["Rot", "90 PS", "X Jahre"]
    ]

);

$array_autos["Alfred"]["Porsche"]= ["Schwarz","12 Jahre","280PS"];

/*echo "<pre>";         --> Zeigt die Variable ohne foreach komplett an
var_dump($array_autos);
echo "</pre>"*/;


foreach ($array_autos as $key => $value) {
    echo "<ul><li>$key</li>
            <ol>";


            foreach ($value as $key => $value){
                echo "<li> $key <br></li>";
                echo"<ul>";
                foreach($value as $value){

                    echo "<li>$value <br></li>";
                }
                echo "</ul>";
            }


         echo"

                <ul>
            </ol>
                </ul>
          </ul>";
}