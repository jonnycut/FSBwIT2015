<?php

/**
 * Created by IntelliJ IDEA.
 * User: JonnyCut
 * Date: 02.03.2016
 * Time: 08:40
 */

if(isset($_GET['name'])){

    echo $_GET['name'];

}else{
    echo "test";
}

$info=[

    'Film' => 'Jochen',
    'FSK' => '18',
    'Länge' => '18 min'


];


echo json_encode($info,JSON_UNESCAPED_UNICODE);
//JSON_UNESCAPED_UNICODE --> Behandlung von UTF-8 Problemen



?>