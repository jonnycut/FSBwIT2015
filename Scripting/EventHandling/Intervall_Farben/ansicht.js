/**
 * Created by JonnyCut on 03.02.2016.
 */
"use strict"

var divElements = document.querySelectorAll('.view');

var buttons = document.querySelectorAll('.viewButton');

for(let i= 0; i<4;i++){

    buttons[i].addEventListener('click',function(){

        hide(divElements);

        divElements[i].style.display = 'block';

    })


}




function hide(liste){

    for(let i=0;i<liste.length;i++){

        liste[i].style.display = 'none';

    }




}
