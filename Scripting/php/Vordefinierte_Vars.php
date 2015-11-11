<?php
/**
 * Created by IntelliJ IDEA.
 * User: JonnyCut
 * Date: 11.11.2015
 * Time: 08:05
 */

$ausgabe = $_SERVER["HTTP_USER_AGENT"];
echo "$ausgabe <br>";

if (strpos($ausgabe, "Mozilla")!== false) {
    echo "Du nutzt FireFox";
} elseif (strpos($ausgabe, "Chrome") !== false) {
    echo "you're using Chrome";
} else {
    echo "nothing found";
}

