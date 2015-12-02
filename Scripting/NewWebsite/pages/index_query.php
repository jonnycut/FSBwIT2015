<?php

$wort = "";
if (isset($_GET['suchbegriff'])) {
   $wort =  $_GET['suchbegriff'];
}
?>


    <form action="" method="get">
        <input type="Search for" value="<?=$wort?>" name="suchbegriff"><br>
        <button type="submit">Suche</button>
        <input type="reset" value="Reset">
        <input type="hidden" name="page" value="index_query">
    </form>

<?php
/**
 * Created by IntelliJ IDEA.
 * User: JonnyCut
 * Date: 18.11.2015
 * Time: 07:37
 */
if (isset($_GET['suchbegriff'])) {


    $url = 'http://www.openthesaurus.de/synonyme/search?q=' . $_GET['suchbegriff'] . '&format=application/json'; #hier die URL angeben
    $auth = base64_encode('KNapret:Oktober2015!'); #Windows-Kennung Bei Start anpassen!
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

    echo "<h1> Synonyme für " . $_GET['suchbegriff'] . "</h1>";
    echo "<br>";

    foreach ($content['synsets'] as $stelle => $synsetArray) {
        foreach ($synsetArray['terms'] as $stelle => $termsArray) {
            echo $termsArray['term'];
            echo "<br>";
        }
    }

}

/*foreach($content['synsets'] as $key => $value){
    echo "<li>";
    foreach($value['terms'] as $terms=>$term){
        echo $term['term'];
    }
    echo "</li>";
}*/


//echo "<pre >";
//    var_dump($content);
//echo "</pre >";
?>