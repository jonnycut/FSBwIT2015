/**
 * Created by JonnyCut on 03.02.2016.
 */

"use strict"

var input_zahl1 = document.getElementById("input_zahl1");
var input_zahl2 = document.getElementById("input_zahl2");
var button_summe = document.getElementById("button_summe");
var button_produkt = document.getElementById("button_produkt");

var ausgabe = document.getElementById('ausgabe');

button_summe.addEventListener('click',function(){

    let zahl1 = +input_zahl1.value;
    let zahl2 = +input_zahl2.value;

    let erg = zahl1 + zahl2;

    ausgabe.innerHTML = erg;



});



