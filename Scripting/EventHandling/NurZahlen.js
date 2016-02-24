/**
 * Created by JonnyCut on 24.02.2016.
 */
"use strict"
var textFeld = document.querySelector('input');

textFeld.addEventListener('keypress', function(e){

    let value = e.keyCode;

    if(value<47 || value>58){

        e.preventDefault();

    }

});

