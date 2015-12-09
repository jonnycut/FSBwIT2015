<?php
/**
 * Created by IntelliJ IDEA.
 * User: KNapret
 * Date: 02.12.2015
 * Time: 10:53
 */

createGallery('./pages/bilder/',4,300,300);

function createGallery($srcdir, $n, $width, $height = null){
    $returnString = "<table><tbody><tr>";
    $bilder = (glob($srcdir.'*.jpg'));
    $counter = 0;


    foreach($bilder as $value){
        $returnString.="<td><img src=".$value." width=".$width." height=".$height."></td>";
        $counter ++;
        if($counter == $n){
            $returnString.="</tr><tr>";

            $counter =0;
        }

    }

    $returnString.="</tr></tbody></table>";

   echo $returnString;
}