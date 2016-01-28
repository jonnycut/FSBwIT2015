/**
 * Created by JonnyCut on 27.01.2016.
 */

    "use strict"

class Kreis{

    constructor(radius, x, y, tempo, farbe){
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.tempo = tempo;
        this.farbe = farbe;
    }

    bewegen(x,y){
        this.x = this.x+x;
        this.y = this.y+y;
    }

    static abstand(kreis1, kreis2){

        var dx = kreis1.x -kreis2.x;
        var dy = kreis1.y-kreis2.y;

        return Math.sqrt(dx*dx+dy*dy);


    }
}


var kreis1 = new Kreis(5,0,0,0,"blau");

var kreis2 = new Kreis(5,5,5,0,"gelb");

