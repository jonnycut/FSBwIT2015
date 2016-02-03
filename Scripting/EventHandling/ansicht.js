/**
 * Created by JonnyCut on 03.02.2016.
 */
"use strict"

var divElements = document.querySelectorAll('div');

var buttons = document.getElementById('button');


hide(divElements);



function hide(liste){

    for(let i=0;i<liste.length;i++){

        liste[i].style.display = 'none';

    }




}
