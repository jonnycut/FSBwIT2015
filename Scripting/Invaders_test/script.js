/**
 * Created by KNapret on 15.03.2016.
 */

"use strict"

var container = document.querySelector('body');
var shooter = document.querySelector('#shooter');
var kugel = document.querySelector('#kugel');
var pauseDiv = document.querySelector('#pause');
var pause = false;


container.addEventListener('keydown',function (e){

    let posX = shooter.getBoundingClientRect().left;
    let key = e.keyCode;



if(pause ==false){

    if(key == 39){ //rechts
        let newPos = posX;
        if(newPos>=930)
            return;

        shooter.style.left = newPos+10+'px';
        kugel.style.left = newPos+10+'px';
        console.log("rechts");

    } else if (key == 37){ //links
        let newPos = posX -10;
        console.log(newPos);
        if(newPos<=140)
            return;

        shooter.style.left = newPos+'px';
        kugel.style.left = newPos+'px';
        console.log("links");
    } else if (key == 32){ //space


        shoot();
        if(e.metaKey == 39)
            console.log('Rechts');


    }
}else{
    if(key ==80){
        pause = false;
        pauseDiv.style.display = 'none';
        if(kugel.getBoundingClientRect().top != shooter.getBoundingClientRect().top)
            shoot();

    }
}



});


function shoot(){

    let kugelY = kugel.getBoundingClientRect().top;
    let kugelX = kugel.getBoundingClientRect().left;
    console.log(kugelY);

    var pauseListener = function (e) {

        let key = e.keyCode;
        if (key == 80) {
            clearInterval(shoot2);
            pause = true;
            //div "pause" anzeigen
            pauseDiv.style.display = 'block';
            container.removeEventListener('keydown', pauseListener);

        }

    }

       var shoot2 = setInterval(function(){
                kugelY--;
                kugel.style.top = kugelY+'px';
                kugel.style.left = kugelX+'px';
                console.log(kugelY);


                container.addEventListener('keydown',pauseListener);


           if(kugelY<=10){
               clearInterval(shoot2);
               kugel.style.top = 785 +'px';
               kugel.style.left = shooter.getBoundingClientRect().left+'px';
           }



        },1);



};