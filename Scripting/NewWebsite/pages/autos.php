<?php
/**
 * Created by IntelliJ IDEA.
 * User: JonnyCut
 * Date: 14.12.2015
 * Time: 19:08
 */


$data = [
    'D100' => [
        'Antrieb' => 'Frontantrieb',
        'Verbrauch' => 4.8],
    'D200' => [
        'Antrieb' => 'Allrad',
        'Verbrauch' => 8],
    'D300' => [
        'Gewicht' => '3000 Kg'],
    'D400' => [
        'Sitzplätze' => 4,
        'Verbrauch' => 5.2]
];

/*echo '<pre>';
var_dump($data);
echo '</pre>';*/


$data['D500'] = ['Verbrauch' => 10];
$data['D200']['Verbrauch']='7';
$gesamtVerb=0;
$autoAnzahl=0;

$liste='<ol>';

foreach($data as $key => $value){
    $liste.="<li>$key</li><ul>";
    foreach($value as $eKey => $eigenschaft){
        $liste.="<li>$eKey : $eigenschaft</li>";
        if($eKey=='Verbrauch'){
            $liste.=" L/100Km";
            $gesamtVerb+=$eigenschaft;
            $autoAnzahl++;
        }

    }
        $liste.='</ul>';

}

$liste.='</ol>';

$durchschnitt = $gesamtVerb / $autoAnzahl;

echo $liste;
echo "Der Durchschnittsverbauch der Flotte liegt bei:$durchschnitt Litern / 100Km"




?>