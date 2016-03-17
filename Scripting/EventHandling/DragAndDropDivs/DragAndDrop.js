/**
 * Created by JonnyCut on 24.02.2016.
 */
"use strict"

let contaier = document.querySelector('#container');



contaier.addEventListener('mousedown',function(e){

   if(e.target === contaier) return;

    let mX = e.clientX;
    let mY = e.clientY;

    let eX = e.target.offsetLeft;
    let eY = e.target.offsetTop;

    let target = e.target;




    var mousemove = function(e){


        let difX = e.clientX - mX;
        let difY = e.clientY - mY;



        target.style.top = eY+difY +'px';
        target.style.left = eX+difX + 'px';





    };



    var mouseup = function(e){

        document.removeEventListener('mousemove',mousemove);
        document.removeEventListener('mouseup',mouseup);
        console.log("entfernt")


    }

    document.addEventListener('mousemove',mousemove)
    document.addEventListener('mouseup', mouseup)

});



