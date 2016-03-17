/**
 * Created by JonnyCut on 16.03.2016.
 */
"use strict"

var html = document.getElementById('tbody');
html.classList.add('ländertabelle');
var button = document.getElementById('changeFarbe');
var nachName = document.getElementById('nachName');
var nachDichte = document.getElementById('nachDichte');

/*---------------------------------------------Länderklasse-----------------------------------------------------------*/

class Land {

    constructor(name, hstadt, einwohner, flaeche, amtssprache) {

        this.name = name;
        this.hstadt = hstadt;
        this.einwohner = einwohner;
        this.flaeche = flaeche;
        this.amtssprache = amtssprache;


    }


    get bevölkerungsDichte() {

        return (this.einwohner / this.flaeche).toFixed(2);

    }


}

var laender = [
    new Land("Deutschland", "Berlin", 81000000, 357000, ["Deutsch"]),
    new Land("Belgien", "Brüssel", 11000000, 31000, ["Niederländisch", "Französisch", "Deutsch"]),
    new Land("Malta", "Valetta", 425000, 316, ["Maltesisch", "Englisch"]),
    new Land("Frankreich","Paris",50000000,357000,["Französisch"]),
    new Land("Holland","Maastricht",12,3000000,["Holländisch"]),
    new Land("Spanien","Madrid",18,30,["Spanisch"])

];


/*---------------------------------------------Tabelle füllen---------------------------------------------------------*/

function tabellenInhalt(laender, html) {

    let string = '';

    for (let i = 0; i < laender.length; i++) {

        string += '<tr><td>' + laender[i].name + '</td><td>' + laender[i].hstadt + '</td><td>' + laender[i].einwohner + '</td><td>' + laender[i].flaeche + '</td><td>' + laender[i].bevölkerungsDichte + '</td><td class="changeC">' + laender[i].amtssprache.join('<br>') + '</td></tr>';

    }

    html.innerHTML = string;

}

tabellenInhalt(laender, html);

/*---------------------------------------------Farbe ändern-----------------------------------------------------------*/


function changeFarbe() {
    let txtField = document.getElementById('farbe');
    let newColor = txtField.value;
    let td = document.getElementsByClassName('changeC');
    console.log(td);

    for (let i = 0; i < td.length; i++) {
        td[i].style.color = newColor;
    }

    /*
     Möglichkeit 2:
     Alle tr im tbody, jeweils das letzte Child eines tr einfärben!

     var trs = document.querySelectorAll('tbody tr');
     for(let i=0;i<trs.length;i++){
     trs[i].lastElementChild.style.color = newColor;
     }*/


}

button.addEventListener('click', function (e) {

    changeFarbe();

});


/*----------------------------------------Sortieren mit Eventlistenern------------------------------------------------*/

nachName.addEventListener('click', function (e) {

    laender.sort(function (a, b) {
        return a.name.localeCompare(b.name);
    });


    tabellenInhalt(laender, html);

    let a = Math.sqrt(14 - ("1" + 4 * "2"));
    console.log(a);


});

nachDichte.addEventListener('click', function (e) {

    laender.sort(function (a, b) {

        return b.bevölkerungsDichte - a.bevölkerungsDichte;

    });

    tabellenInhalt(laender, html);

});

/*------------------------------------------------- BMI Rechner ------------------------------------------------------*/

function bmi() {

    let gewicht = document.getElementById('gewicht');
    let groesse = document.getElementById('größe');
    let btnBerechnen = document.getElementById('berechnen');
    let btnReset = document.getElementById('reset');
    let mann = document.getElementById('mann');
    let frau = document.getElementById('frau');

    btnReset.addEventListener('click', function (e){

        gewicht.value = '';
        groesse.value = '';
        ausgabe.innerHTML ='';

    })

    btnBerechnen.addEventListener('click', function(e){

        let groesseV = groesse.value;
        let gewichtV = gewicht.value;
        let bmi = (gewichtV/(groesseV*groesseV)).toFixed(0);



        if(mann.checked){
            if(bmi<20){
                bmi +="   Sie haben Untergewicht!"
            }

        }else if(frau.checked){

            if(bmi<19){
                bmi +="   Die haben Untergewicht!";
            }
        }

        ausgabe.innerHTML = "Ihr BMI beträgt:  " + bmi;





    })

}

bmi();

/*---------------------------------------- Elemente aus Array löschen-------------------------------------------------*/


var nachLand = document.getElementById('nachLand');
var nachZeile = document.getElementById('nachZeile');
var btnDelete = document.getElementById('btnDelete');
var txtDelete = document.getElementById('txtDelete');

function del(){


    console.log("lösche");
    if(nachLand.checked){

        for(let i=0;i<laender.length;i++) {

            if (laender[i].name == txtDelete.value) {
                laender.splice(i, 1);
                //array.splice(Start,Anzahl);

            }
        }

        }else{
            laender.splice(txtDelete.value-1,1);
        }

        console.log(laender);
        tabellenInhalt(laender,html);


}

btnDelete.addEventListener('click',del);












