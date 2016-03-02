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

    'Film' => 'Deadpool',
    'FSK' => '18',
    'Länge' => '18 min'


];

echo json_encode($info);



?>