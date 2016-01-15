/**
 * Created by KNapret on 13.01.2016.
 */
"use strict";

var a = 2;
var b = 3;
var c = add(a, b);

/* Ausgabe in der Konsole */
console.log(c);

/* Funktion add */
function add(x, y) {
    var z = x + y;
    return z;
}

var a = Math.ceil(Math.random()*10+10);
var b = Math.ceil(Math.random()*10+10);
var c = Math.ceil(Math.random()*10+10);
var d = Math.floor(Math.random()*5+4);
var e = Math.floor(Math.random()*5+4);

var min = Math.min(a, b, c, d, e);
var max = Math.max(a, b, c, d, e);

var durchschnitt = (a+b+c+d+e) /5;

if(Number.isInteger(durchschnitt)){
    console.log('Ist integer');
}else{
    console.log('kein Integer')
}

