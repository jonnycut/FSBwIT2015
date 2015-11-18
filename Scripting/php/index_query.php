<?php
/**
 * Created by IntelliJ IDEA.
 * User: JonnyCut
 * Date: 18.11.2015
 * Time: 07:37
 */

$url = 'http://www.openthesaurus.de/synonyme/search?q=Mond&format=application/json'; #hier die URL angeben
$auth = base64_encode('USERNAME:PASSOWRT'); #Windows-Kennung Bei Start anpassen!
$proxy_resource = array(
    'http' => array(
        'proxy' => 'tcp://proxy:8080',
        'request_fulluri' => true,
        'header' => "Proxy-Authorization: Basic $auth",
    ),
);
$stream_content = stream_context_create($proxy_resource);
$json = file_get_contents($url, false, $stream_content);

$content = json_decode($json, true); #true nicht vergessen --> Erstellt ein Array aus dem gedöns

#$content['synsets'][0]['terms'][0]['term']

foreach($content['synsets'] as $stelle => $synsetArray){
    foreach($synsetArray['terms'] as $stelle => $termsArray){
        echo $termsArray['term'];
    }
}

/*foreach($content['synsets'] as $key => $value){
    echo "<li>";
    foreach($value['terms'] as $terms=>$term){
        echo $term['term'];
    }
    echo "</li>";
}*/


echo "<pre >";
    var_dump($content);
echo "</pre >";
?>