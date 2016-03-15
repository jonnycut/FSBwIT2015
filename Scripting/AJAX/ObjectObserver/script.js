/**
 * Created by JonnyCut on 14.03.2016.
 */
"use strict"

var username = {

    vorname: '',
    nachname: ''

};

var zustand ={

    status: 0

}

//querySelectorAll('NAME / TYP / ID des Elements')[STELLE DES QUEREY ARRAYS].addEventListener('typ, was passiert',function()...


function controller_reg(){

    let div = document.querySelector('#registrierung');

    div.classList.add('show');


    document.querySelectorAll('#registrierung input')[0].addEventListener('input', function(){

        username.vorname = this.value;
    });


    document.querySelectorAll('#registrierung input')[1].addEventListener('input', function(){

        username.nachname = this.value;
    });


    document.querySelectorAll('#submit')[0].addEventListener('click', function(){

        if(username.vorname!= '' && username.nachname != ''){

            div.classList.remove('show');
            zustand.status = 2;




        }


    });
}

function controller_anwendung(){

    let div = document.querySelector('#anwendung');
    div.classList.add('show');


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

//observer für den Automaten

Object.observe(zustand, function(changes){
    changes.forEach(function(change){
        if(change.name === 'status') { //name der Attribute

            switch (change.object.status){

                case 1:
                    controller_reg();
                    break;

                case 2:
                    controller_anwendung();
                    break;
            }

        }
    });
});


zustand.status = 1;