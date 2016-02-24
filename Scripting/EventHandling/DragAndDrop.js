/**
 * Created by JonnyCut on 24.02.2016.
 */
"use strict"

let contaier = document.querySelector('#container');



contaier.addEventListener('mousedown',function(e){

   if(e.target === container) return;

    let mX = e.clientX;
    let mY = e.clientY;
    let eX = e.offsetTop;
    let eY = e.offsetLeft;


    contaier.addEventListener('mousemove',move);

    function move(e){

        if (e.target === contaier) return;
        let difX = e.clientX - mX;
        let difY = e.clientY -mY;



        e.target.style.top = mY-difY +"px";
        e.target.style.left = mX-difX + "px";






        console.log(difX)

    };

    contaier.addEventListener('mouseup',up);

    function up(e){

        contaier.removeEventListener('mousemove',move);
        contaier.removeEventListener('mouseup',up);
        console.log("entfernt")


    }

});



