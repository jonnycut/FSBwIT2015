/**
 * Created by KNapret on 27.01.2016.
 */

"use strict"

var rechteck = {
    width: 200,
    height: 50,
    color: 'blue',
    get umfang(){
        return this.width * 2 + this.height *2;
    },

    get builtHTML(){

        //return "<div style ='width:"+this.width+"px; height: "+this.height+"px; background-color: "+this.color+"'></div>"

        //template... wichtig: Das Template muss mit ` eingefasst sein
        return `<div style="
        width: ${this.width}px;
        height: ${this.height}px;
        background-color: ${this.color}
        "></div>`;

    }
};


var zahlen1 = [2,9,8,7,0,122];
var zahlen2 = [1,6,3,5,4,10,24556];

toOne(zahlen1,zahlen2);


function toOne(arr1, arr2){

   var retArray =  arr1.concat(arr2);

    retArray.sort(function(a,b){return a-b});

    console.log(retArray);

}


document.body.innerHTML = rechteck.builtHTML;
