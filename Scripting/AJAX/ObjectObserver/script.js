/**
 * Created by JonnyCut on 14.03.2016.
 */
"use strict"

var username = {

    vorname: '',
    nachname: ''

};

//querySelectorAll('NAME / TYP / ID des Elements')[STELLE DES QUEREY ARRAYS].addEventListener('typ, was passiert',function()...


function controller_reg(){

    document.querySelectorAll('#registrierung input')[0].addEventListener('input', function(){

        username.vorname = this.value;
    });


    document.querySelectorAll('#registrierung input')[1].addEventListener('input', function(){

        username.nachname = this.value;
    });


    document.querySelectorAll('#delete')[0].addEventListener('click', function(){


        username.vorname = ''
        username.nachname = ''


    });
}




//observer können Objecte überwachen

Object.observe(username, function(changes){
    changes.forEach(function(change){
        if(change.name === 'vorname' || change.name === 'nachname') { //name der Attribute
            document.querySelector('span').textContent = change.object.vorname + ' ' +
                change.object.nachname;
        }
    });
});

controller_reg();