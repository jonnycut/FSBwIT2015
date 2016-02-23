/**
 * Created by JonnyCut on 10.02.2016.
 */

    "use strict"

var tbody = document.getElementsByTagName('tbody')[0];
var rot = document.getElementById("rot");
var gruen = document.getElementById("gruen");
var blau = document.getElementById("blau");
var choose ="";

rot.addEventListener('click',drawTable);
gruen.addEventListener('click',drawTable);
blau.addEventListener('click',drawTable);









function drawTable(){
    var content = '';
    var counterR = 0;
    var counterG = 0;
    var counterB = 0;


    for(let i = 0; i<16;i++){
        content +='<tr>';

        for(let j =0;j<16;j++){

            content+='<td style="background-color:  rgb('
            content += counterR + ',' + counterG +',' + counterB+')"></td>';

            if(this.id =="rot"){
                counterR++;
            }else if(this.id =="gruen"){
                counterG++;
            }else if (this.id=="blau"){
                counterB++;
            }else if(id == null){

            };



        }

        content+='</tr>'



    }//outerFor
    tbody.innerHTML = content;
}


