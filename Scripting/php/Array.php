
<!-- ToDo: Ausgabe richtig anpassen -->

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



foreach ($array_autos as $key => $value) {
    echo "<ul><li>$key</li>
            <ol><li>";


            foreach ($value as $key => $value){
                echo "$key <br>";
                foreach($value as $value){

                    echo "$value <br>";
                }
            }


         echo"
            </li>
                <ul><li>


                </li>
            </ol>
                </ul>
          </ul>";
}