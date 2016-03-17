/**
 * Created by JonnyCut  on 03.02.2016.
 */


"use strict"

var farben = ['salmon', 'aqua', 'gold', 'pink'];

var pElemente = document.querySelectorAll('p');

var id = setInterval(function () {

    for (let i = 0; i < pElemente.length; i++) {

        let farbe = farben[Math.floor(Math.random() * farben.length)];

        pElemente[i].style.backgroundColor = farbe;

    }


}, 1000);


