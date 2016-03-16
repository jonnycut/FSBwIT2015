/**
 * Created by JonnyCut on 16.03.2016.
 */
"use strict"

var html = document.getElementById('tbody');
html.classList.add('ländertabelle');
var button = document.getElementById('changeFarbe');
var nachName = document.getElementById('nachName');
var nachDichte = document.getElementById('nachDichte');

class Land{

    constructor(name, hstadt, einwohner, flaeche, amtssprache){

        this.name = name;
        this.hstadt = hstadt;
        this.einwohner = einwohner;
        this.flaeche = flaeche;
        this.amtssprache = amtssprache;



    }


    get bevölkerungsDichte(){

        return (this.einwohner/this.flaeche).toFixed(2);

    }


}

var laender = [
    new Land("Deutschland","Berlin",81000000,357000,["Deutsch"]),
    new Land("Belgien","Brüssel",11000000,31000,["Niederländisch", "Französisch","Deutsch"]),
    new Land("Malta","Valetta",425000,316,["Maltesisch","Englisch"])

];



function tabellenInhalt(laender,html){

    let string = '';

    for(let i=0; i<laender.length; i++){

        string += '<tr><td>'+laender[i].name+'</td><td>'+laender[i].hstadt+'</td><td>'+laender[i].einwohner+'</td><td>'+laender[i].flaeche+'</td><td>'+laender[i].bevölkerungsDichte+'</td><td class="changeC">'+laender[i].amtssprache.join('<br>')+'</td></tr>';

    }

    html.innerHTML = string;

}

tabellenInhalt(laender,html);

function changeFarbe(){
    let txtField = document.getElementById('farbe');
    let newColor = txtField.value;
    let td = document.getElementsByClassName('changeC');
    console.log(td);

    for(let i=0; i<td.length;i++){
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

button.addEventListener('click',function(e){

    changeFarbe();

});

nachName.addEventListener('click',function(e){

    laender.sort(function(a,b){
        return a.name.localeCompare(b.name);
    });


    tabellenInhalt(laender,html);


});

nachDichte.addEventListener('click', function (e){

    laender.sort(function(a,b){

        return b.bevölkerungsDichte - a.bevölkerungsDichte;

    });

    tabellenInhalt(laender,html);

});































